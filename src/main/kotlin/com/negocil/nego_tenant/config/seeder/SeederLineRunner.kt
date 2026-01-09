package com.negocil.nego_tenant.config.seeder

import com.negocil.nego_tenant.modules.tenant.seeder.TenantSeeder
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class SeederLineRunner(
    val tenantSeeder: TenantSeeder
): CommandLineRunner {

    override fun run(vararg args: String) {
        tenantSeeder.run()
    }
}
