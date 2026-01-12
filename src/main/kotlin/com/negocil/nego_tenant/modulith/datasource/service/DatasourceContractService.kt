package com.negocil.nego_tenant.modulith.datasource.service

import com.negocil.nego_tenant.modulith.datasource.controller.response.DatasourcePage
import com.negocil.nego_tenant.modulith.datasource.repository.DatasourceContractRepo
import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.shared.service.ConcreteService
import com.negocil.nego_tenant.shared.util.PaginateDto
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

abstract class DatasourceContractService(
    private val datasourceRepo: DatasourceContractRepo
): ConcreteService<DatasourceTenant>(datasourceRepo) {

    fun paginate(paginate: Pageable) = DatasourcePage(super.findAll(paginate))

    fun paginate(paginateDto: PaginateDto) = DatasourcePage(super.findAll(
        PageRequest.of(paginateDto.pageNumber, paginateDto.pageSize))
    )

    fun findByPort(port: Long, pageable: Pageable) = datasourceRepo.findByPort(port, pageable)

    fun findByHost(host: String, pageable: Pageable) = datasourceRepo.findByHost(host, pageable)

    fun findByDbname(dbname: String,pageable: Pageable) = datasourceRepo.findByDbname(dbname, pageable)

    fun findByUsername(username: String, pageable: Pageable) = datasourceRepo.findByUsername(username, pageable)

    fun findByDriver(driver: String, pageable: Pageable) = datasourceRepo.findByDriver(driver, pageable)
}