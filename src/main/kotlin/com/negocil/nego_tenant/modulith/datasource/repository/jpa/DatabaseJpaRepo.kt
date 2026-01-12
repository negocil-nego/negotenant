package com.negocil.nego_tenant.modulith.datasource.repository.jpa

import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.shared.repo.jpa.JpaConcreteRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface DatabaseJpaRepo: JpaConcreteRepo<DatasourceTenant> {
    fun findByPort(port: Long, pageable: Pageable): Page<DatasourceTenant>
    fun findByHost(host: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByDbname(dbname: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByUsername(username: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByDriver(driver: String, pageable: Pageable): Page<DatasourceTenant>
}