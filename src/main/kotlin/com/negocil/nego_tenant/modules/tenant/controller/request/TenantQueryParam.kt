package com.negocil.nego_tenant.modules.tenant.controller.request

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


class TenantQueryParam(
    val name: String = "",
    val code: String = "",
    pageNumber: Int = 9,
    pageSize: Int = 50,
): PageRequest(pageNumber, pageSize, Sort.unsorted()) {
    override fun getPageNumber(): Int {
        return super.getPageNumber()
    }
}