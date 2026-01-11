package com.negocil.nego_tenant.modulith.datasource.web.dto

import com.negocil.nego_tenant.modulith.datasource.domain.enum.SgbType
import com.negocil.nego_tenant.modulith.datasource.domain.model.DatasourceTenant
import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import java.util.UUID

data class DatasourceDto(
    var databaseType: SgbType,
    var tenantUuid: String,
    var username: String,
    var password: String,
    var dbname: String,
    var driver: String,
    var host: String,
    var port: Long
){
    fun toModel(): DatasourceTenant = DatasourceTenant(
        tenant = Tenant(uuid = UUID.fromString(tenantUuid)),
        databaseType= databaseType,
        username = username,
        password = password,
        dbname = dbname,
        driver = driver,
        host = host,
        port = port,
    )
}
