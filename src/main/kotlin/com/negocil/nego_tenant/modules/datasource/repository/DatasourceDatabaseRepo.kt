package com.negocil.nego_tenant.modules.datasource.repository

import com.negocil.nego_tenant.modules.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modules.datasource.repository.jpa.DatabaseJpaRepo
import com.negocil.nego_tenant.shared.repo.jpa.impl.JpaConcreteRepoImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class DatasourceDatabaseRepo(
    private val repository: DatabaseJpaRepo
): JpaConcreteRepoImpl<DatasourceTenant>(repository), DatasourceContractRepo {

    override fun findByPort(port: Long, pageable: Pageable) = repository.findByPort(port, pageable)

    override fun findByHost(host: String, pageable: Pageable) = repository.findByHost(host, pageable)

    override fun findByDbname(dbname: String,pageable: Pageable) = repository.findByDbname(dbname, pageable)

    override fun findByUsername(username: String, pageable: Pageable) = repository.findByUsername(username, pageable)

    override fun findByDriver(driver: String, pageable: Pageable) = repository.findByDriver(driver, pageable)
}