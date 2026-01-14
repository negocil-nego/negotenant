package com.negocil.nego_tenant.modulith.tenant.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.security.SecureRandom
import java.util.Base64
import java.util.Optional
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.Cipher

@Component
class EncryptionService(
    @Value("\${security.encryption.secret-key}")
    private val secretKeyString: String
) {
    private val ALGORITHM = "AES"
    private val TRANSFORMATION = "AES/GCM/NoPadding"
    private val GCM_TAG_LENGTH = 128
    private val GCM_IV_LENGTH = 12

    private val secretKey: SecretKey by lazy {
        val decodedKey = Base64.getDecoder().decode(secretKeyString)
        SecretKeySpec(decodedKey, 0, decodedKey.size, ALGORITHM)
    }

    fun generateSecretKey(): String {
        val keyGen = KeyGenerator.getInstance(ALGORITHM)
        keyGen.init(256, SecureRandom())
        val secretKey = keyGen.generateKey()
        return Base64.getEncoder().encodeToString(secretKey.encoded)
    }

    fun encrypt(plainText: String): String {
        if (plainText.isBlank()) return plainText

        val iv = ByteArray(GCM_IV_LENGTH)
        SecureRandom().nextBytes(iv)

        val cipher = Cipher.getInstance(TRANSFORMATION)
        val gcmSpec = GCMParameterSpec(GCM_TAG_LENGTH, iv)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmSpec)

        val encrypted = cipher.doFinal(plainText.toByteArray(Charsets.UTF_8))
        val combined = iv + encrypted
        return Base64.getEncoder().encodeToString(combined)
    }

    fun decrypt(encryptedText: String): String {
        if (encryptedText.isBlank()) return encryptedText

        val combined = Base64.getDecoder().decode(encryptedText)

        val iv = combined.sliceArray(0 until GCM_IV_LENGTH)
        val encrypted = combined.sliceArray(GCM_IV_LENGTH until combined.size)

        val cipher = Cipher.getInstance(TRANSFORMATION)
        val gcmSpec = GCMParameterSpec(GCM_TAG_LENGTH, iv)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec)

        val decrypted = cipher.doFinal(encrypted)

        return String(decrypted, Charsets.UTF_8)
    }
}