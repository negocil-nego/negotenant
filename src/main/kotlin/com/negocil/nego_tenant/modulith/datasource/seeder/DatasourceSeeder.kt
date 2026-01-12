package com.negocil.nego_tenant.modulith.datasource.seeder

import com.negocil.nego_tenant.modulith.datasource.service.DatasourceDatabaseService
import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.contracts.SeederRun
import org.springframework.stereotype.Component

@Component
class DatasourceSeeder(
    val service: DatasourceDatabaseService,
): SeederRun<DatasourceTenant> {
    private var datasouces: List<DatasourceTenant>  = emptyList()
    var tenants: List<Tenant> = emptyList()


    override fun items() = datasouces

    override fun run() {
        datasouces = DatasourceData.entries.mapNotNull { item ->
            val tenant = tenants.find { it.name == item.datasource.tenant.name }
            tenant?.let {
                item.datasource.tenant = it
                service.saveOrUpdate(item.datasource)
            }
        }
    }
}