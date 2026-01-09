package com.negocil.nego_tenant.modules.datasource.service

import com.negocil.nego_tenant.modules.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modules.datasource.repository.DatasourceContractRepo
import com.negocil.nego_tenant.shared.service.ConcreteService
import org.springframework.data.domain.Pageable

abstract class DatasourceContractService(
    private val datasourceRepo: DatasourceContractRepo
): ConcreteService<DatasourceTenant>(datasourceRepo) {

    override fun save(data: DatasourceTenant): DatasourceTenant {
        return super.save(data)
    }

    fun findByPort(port: Long, pageable: Pageable) = datasourceRepo.findByPort(port, pageable)

    fun findByHost(host: String, pageable: Pageable) = datasourceRepo.findByHost(host, pageable)

    fun findByDbname(dbname: String,pageable: Pageable) = datasourceRepo.findByDbname(dbname, pageable)

    fun findByUsername(username: String, pageable: Pageable) = datasourceRepo.findByUsername(username, pageable)

    fun findByDriver(driver: String, pageable: Pageable) = datasourceRepo.findByDriver(driver, pageable)
}