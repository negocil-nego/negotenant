package com.negocil.nego_tenant.modulith.tenant.web.response

import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import com.negocil.nego_tenant.shared.util.PageResponse
import org.springframework.data.domain.Page

class TenantPage(
    content: List<Tenant> = emptyList(),
    empty: Boolean = false,
    first: Boolean = false,
    last: Boolean = false,
    number: Int = 0,
    numberOfElements: Int = 0,
    size: Int = 0,
    totalElements: Long = 0,
    totalPages: Int = 0
) : PageResponse<Tenant>(
    content = content,
    empty = empty,
    first = first,
    last = last,
    number = number,
    numberOfElements = numberOfElements,
    size = size,
    totalElements = totalElements,
    totalPages = totalPages
) {

    constructor(page: Page<Tenant>) : this(
        content = page.content,
        empty = page.isEmpty,
        first = page.isFirst,
        last = page.isLast,
        number = page.number,
        numberOfElements = page.numberOfElements,
        size = page.size,
        totalElements = page.totalElements,
        totalPages = page.totalPages
    )

    companion object {
        fun of(page: Page<Tenant>): TenantPage = TenantPage(page)
    }
}
