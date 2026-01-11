package com.negocil.nego_tenant.modulith.tenant.data.seeder

import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import com.negocil.nego_tenant.modulith.tenant.data.service.TenantDatabaseService
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