package com.negocil.nego_tenant.modulith.tenant.repository.jpa

import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.repo.jpa.JpaConcreteRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface TenantJpaRepo: JpaConcreteRepo<Tenant> {
    fun findByName(name: String, pageable: Pageable): Page<Tenant>

    fun findByPassword(password: String, pageable: Pageable): Page<Tenant>

    fun findByKey(key: String): Optional<Tenant>
}