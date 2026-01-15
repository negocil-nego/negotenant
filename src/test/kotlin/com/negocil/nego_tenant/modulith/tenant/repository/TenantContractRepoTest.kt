package com.negocil.nego_tenant.modulith.tenant.repository

import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.repo.ConcreteRepoTest
import org.junit.jupiter.api.Test

abstract class TenantContractRepoTest: ConcreteRepoTest<Tenant>() {
     private lateinit var tenantContractRepo: TenantContractRepo

    fun setRepo(tenantContractRepo: TenantContractRepo) {
       super.setRepo(tenantContractRepo)
        this.tenantContractRepo = tenantContractRepo
    }

    @Test
    fun findByName_WhenDoesThrow() {

    }

    @Test
    fun findByPassword_WhenDoesThrow() {

    }

    @Test
    fun findByKey_WhenDoesThrow() {

    }
}