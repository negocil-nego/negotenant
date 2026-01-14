package com.negocil.nego_tenant.modulith.tenant.model

import com.negocil.nego_tenant.modulith.tenant.seeder.TenantData
import com.negocil.nego_tenant.shared.model.ConcreteModelTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TenantTest(
    private val model: Tenant = TenantData.NETENANT.tenant
): ConcreteModelTest(model){

    @Test
    fun nameNotEmpty() {
        assertTrue {  model.name.isNotEmpty() }
    }

}