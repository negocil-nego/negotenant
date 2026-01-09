package com.negocil.nego_tenant.modules.datasource.repository

import com.negocil.nego_tenant.modules.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.shared.repo.ConcreteRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DatasourceContractRepo: ConcreteRepo<DatasourceTenant> {
    fun findByPort(port: Long, pageable: Pageable): Page<DatasourceTenant>
    fun findByHost(host: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByDbname(dbname: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByUsername(username: String, pageable: Pageable): Page<DatasourceTenant>
    fun findByDriver(driver: String, pageable: Pageable): Page<DatasourceTenant>
}