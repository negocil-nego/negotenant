package com.negocil.nego_tenant.shared.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.io.Serializable

@MappedSuperclass
abstract class CommonModel(
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id: Long = 0L
): Serializable