package com.negocil.nego_tenant.modules.datasource.dto

import com.negocil.nego_tenant.modules.datasource.enum.SgbType
import com.negocil.nego_tenant.modules.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modules.tenant.model.Tenant
import java.util.UUID

data class DatasourceDto(
    var databaseType: SgbType,
    var tenantUuid: UUID,
    var username: String,
    var password: String,
    var dbname: String,
    var driver: String,
    var host: String,
    var port: Long
){
    fun toModel(): DatasourceTenant = DatasourceTenant(
        tenant = Tenant(uuid = tenantUuid),
        databaseType= databaseType,
        username = username,
        password = password,
        dbname = dbname,
        driver = driver,
        host = host,
        port = port,
    )
}
