package com.negocil.nego_tenant.modulith.tenant.data.service

import com.negocil.nego_tenant.modulith.tenant.web.response.TenantPage
import com.negocil.nego_tenant.modulith.tenant.data.repoisitory.TenantContractRepo
import com.negocil.nego_tenant.shared.service.ConcreteService
import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import com.negocil.nego_tenant.shared.util.PaginateDto
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

abstract class TenantContractService(
    val tenantContractRepo: TenantContractRepo
): ConcreteService<Tenant>(tenantContractRepo) {

    fun paginate(paginate: Pageable) = TenantPage(super.findAll(paginate))

    fun paginate(paginateDto: PaginateDto) = TenantPage(super.findAll(
        PageRequest.of(paginateDto.pageNumber, paginateDto.pageSize))
    )

    fun findByName(name: String, pageable: Pageable) = tenantContractRepo.findByName(name, pageable)

    fun findByPassword(password: String, pageable: Pageable) = tenantContractRepo.findByPassword(password, pageable)
}