package com.negocil.nego_tenant.modulith.tenant.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modulith.tenant.controller.response.TenantResponse
import com.negocil.nego_tenant.shared.contracts.SoftDeleteFieldUnique
import com.negocil.nego_tenant.shared.model.ConcreteModel
import com.negocil.nego_tenant.shared.util.NamedTable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import java.util.UUID
import kotlin.Boolean

@Entity(name = NamedTable.TENANT)
class Tenant(
    var name: String = "",
    @JsonIgnore
    @Column(unique = true)
    var key: String = "",
    @JsonIgnore
    var password: String = "",
    @JsonIgnore
    @OneToMany(mappedBy = "tenant", fetch = FetchType.LAZY)
    var datasourceTenants: MutableList<DatasourceTenant> = mutableListOf(),
    uuid: UUID = UUID.randomUUID(),
    deleted: Boolean = false,
    override var id: Long = 0,
): ConcreteModel(deleted = deleted, uuid = uuid, id = id), SoftDeleteFieldUnique {

    override fun preSoftDeleteFieldUnique() { key += id }

    override fun toString(): String {
        return "Tenant(id=$id, uuid=$uuid, name=$name, key=$key, deleted=$deleted)"
    }

    fun toResponse() = TenantResponse(uuid = uuid, name = name)
}