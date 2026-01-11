package com.negocil.nego_tenant.modulith.tenant.data.repoisitory

import com.negocil.nego_tenant.shared.repo.jpa.impl.JpaConcreteRepoImpl
import com.negocil.nego_tenant.modulith.tenant.data.repoisitory.jpa.TenantJpaRepo
import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class TenantDatabaseRepo(
    private val repository: TenantJpaRepo
): JpaConcreteRepoImpl<Tenant>(repository), TenantContractRepo {
    override fun findByName(name: String, pageable: Pageable) = repository.findByName(name, pageable)

    override fun findByPassword(password: String, pageable: Pageable) = repository.findByPassword(password, pageable)

    override fun findByKey(key: String) = repository.findByKey(key)
}