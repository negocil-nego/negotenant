package com.negocil.nego_tenant.modulith.datasource.model

import com.negocil.nego_tenant.modulith.datasource.enum.SgbType
import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.model.ConcreteModel
import com.negocil.nego_tenant.shared.util.NamedTable
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.negocil.nego_tenant.modulith.datasource.controller.response.DatasourceResponse
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import jakarta.persistence.EnumType
import jakarta.persistence.Entity
import java.util.UUID

@Entity(name = NamedTable.DATASOURCE)
class DatasourceTenant (
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    var tenant: Tenant,
    @JsonIgnore
    var port: Long = 5432,
    @JsonIgnore
    var host: String = "localhost",
    @JsonIgnore
    var dbname: String,
    @JsonIgnore
    var username: String = "",
    @JsonIgnore
    var password: String = "",
    @JsonIgnore
    var driver: String = "jdbc",
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    var databaseType: SgbType = SgbType.POSTGRESQL,
    uuid: UUID = UUID.randomUUID(),
    deleted: Boolean = false,
    id: Long = 0
): ConcreteModel(deleted = deleted, uuid = uuid, id = id) {

    fun toResponse() = DatasourceResponse(uuid = uuid, tenant = tenant.toResponse())

}