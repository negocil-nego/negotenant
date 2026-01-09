package com.negocil.nego_tenant.modules.datasource.model

import com.negocil.nego_tenant.modules.datasource.enum.SgbType
import com.negocil.nego_tenant.modules.tenant.model.Tenant
import com.negocil.nego_tenant.shared.model.ConcreteModel
import com.negocil.nego_tenant.shared.util.NamedTable
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity(name = NamedTable.DATASOURCE)
class DatasourceTenant (
    @ManyToOne(fetch = FetchType.LAZY)
    var tenant: Tenant,
    var port: Long = 5432,
    var host: String = "localhost",
    var dbname: String,
    var username: String = "",
    var password: String = "",
    var driver: String = "jdbc",
    @Enumerated(EnumType.STRING)
    var databaseType: SgbType = SgbType.POSTGRESQL,
    uuid: UUID = UUID.randomUUID(),
    deleted: Boolean = false,
    id: Long = 0
): ConcreteModel(deleted = deleted, uuid = uuid, id = id)