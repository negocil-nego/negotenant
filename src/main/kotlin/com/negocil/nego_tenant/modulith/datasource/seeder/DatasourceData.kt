package com.negocil.nego_tenant.modulith.datasource.seeder

import com.negocil.nego_tenant.modulith.datasource.enum.SgbType
import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modulith.tenant.seeder.TenantData

enum class DatasourceData(val datasource: DatasourceTenant) {
    TENANT_NEGOCAR(DatasourceTenant(
        tenant = TenantData.NEGOCAR.tenant,
        databaseType = SgbType.POSTGRESQL,
        dbname = "tenant_negocar",
        username = "postgres",
        password = "postgres",
        host = "localhost",
        driver  = "jdbc",
        port  = 5432,
    )),
    TENANT_NEGOLAR(DatasourceTenant(
        tenant = TenantData.NEGOLAR.tenant,
        databaseType = SgbType.POSTGRESQL,
        dbname = "tenant_negolar",
        username = "postgres",
        password = "postgres",
        host = "localhost",
        driver  = "jdbc",
        port  = 5432,
    ))
}