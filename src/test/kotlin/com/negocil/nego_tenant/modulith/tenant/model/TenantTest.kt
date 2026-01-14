package com.negocil.nego_tenant.modulith.tenant.model

import com.negocil.nego_tenant.modulith.tenant.faker.TenantFaker
import com.negocil.nego_tenant.shared.model.ConcreteModelTest
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TenantTest: ConcreteModelTest(TenantFaker.model) {
    private val tenant: Tenant = TenantFaker.model

    @Test
    fun name_ShouldBeNotEmpty() {
        assertTrue(tenant.name.isNotEmpty())
    }

    @Test
    fun password_ShouldBeNotEmpty() {
        assertTrue(tenant.password.isNotEmpty())
    }

    @Test
    fun key_ShouldBeNotEmpty() {
        assertTrue(tenant.key.isNotEmpty())
    }
}