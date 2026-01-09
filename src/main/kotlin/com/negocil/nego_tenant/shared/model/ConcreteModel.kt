package com.negocil.nego_tenant.shared.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.SQLRestriction
import java.util.UUID

@MappedSuperclass
@SQLRestriction(value = "deleted = false")
abstract class ConcreteModel(
    @JsonIgnore
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    var deleted: Boolean = false,
    @Column(nullable = false, unique = true, updatable = false)
    var uuid: UUID = UUID.randomUUID(),
    id: Long = 0L
): CommonModel(id = id)