package com.negocil.nego_tenant.modulith.tenant.seeder

import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.modulith.tenant.service.TenantDatabaseService
import com.negocil.nego_tenant.shared.contracts.SeederRun
import org.springframework.stereotype.Component

@Component
class TenantSeeder(
    val service: TenantDatabaseService
): SeederRun<Tenant> {
    var tenants = listOf<Tenant>()

    override fun items() = tenants

    override fun run() {
        tenants = TenantData.entries.stream().map {
            service.saveOrUpdate(it.tenant)
        }.toList()
    }
}