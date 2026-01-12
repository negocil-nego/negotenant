package com.negocil.nego_tenant.config.seeder

import com.negocil.nego_tenant.modulith.datasource.seeder.DatasourceSeeder
import com.negocil.nego_tenant.modulith.tenant.seeder.TenantSeeder
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SeederLineRunner(
    val tenantSeeder: TenantSeeder,
    val datasourceSeeder: DatasourceSeeder
): CommandLineRunner {

    override fun run(vararg args: String) {
        tenantSeeder.run()

        datasourceSeeder.tenants = tenantSeeder.tenants
        datasourceSeeder.run()
    }
}
