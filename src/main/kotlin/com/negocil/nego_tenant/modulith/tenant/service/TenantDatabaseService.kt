package com.negocil.nego_tenant.modulith.tenant.service

import com.negocil.nego_tenant.modulith.tenant.repository.TenantDatabaseRepo
import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.modulith.tenant.util.EncryptionService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class TenantDatabaseService(
    tenantDatabaseRepo: TenantDatabaseRepo,
    private val encryptionService: EncryptionService
): TenantContractService(tenantDatabaseRepo) {

    override fun save(data: Tenant): Tenant {
        val password = data.password.ifBlank { UUID.randomUUID().toString() }
        data.key = encryptionService.generateSecretKey()
        data.password = encryptionService.encrypt(password)
        return super.save(data)
    }

    fun saveOrUpdate(data: Tenant): Tenant {
        val item = tenantContractRepo.findByKey(data.key)
        return if (item.isPresent) {
            data.id = item.get().id
            data.uuid = item.get().uuid
            tenantContractRepo.save(data)
        } else {
            save(data)
        }
    }

}