package com.negocil.nego_tenant.modulith.tenant.repository

import com.negocil.nego_tenant.modulith.tenant.repository.jpa.TenantJpaRepo
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest

@DataJpaTest
class TenantDatabaseRepoTest: TenantContractRepoTest()  {
    @Autowired private lateinit var tenantJpaRepo: TenantJpaRepo

    private lateinit var tenantDatabaseRepo: TenantDatabaseRepo

    @BeforeEach
    fun setUp() {
        tenantDatabaseRepo = TenantDatabaseRepo(tenantJpaRepo)
        super.setRepo(tenantDatabaseRepo)
    }
}