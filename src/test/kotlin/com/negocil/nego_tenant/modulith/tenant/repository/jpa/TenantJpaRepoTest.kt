package com.negocil.nego_tenant.modulith.tenant.repository.jpa

import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.repo.jpa.JpaConcreteRepoTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest

@DataJpaTest
class TenantJpaRepoTest: JpaConcreteRepoTest<Tenant>() {

    @Autowired lateinit var tenantJpaRepo: TenantJpaRepo

    @BeforeEach
    fun setRepo() {
        setRepo(tenantJpaRepo)
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