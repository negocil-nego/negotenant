package com.negocil.nego_tenant.modulith.datasource.web.response

import com.negocil.nego_tenant.modulith.datasource.domain.model.DatasourceTenant
import com.negocil.nego_tenant.shared.util.PageResponse
import org.springframework.data.domain.Page

class DatasourcePage (
    content: List<DatasourceTenant> = emptyList(),
    empty: Boolean = false,
    first: Boolean = false,
    last: Boolean = false,
    number: Int = 0,
    numberOfElements: Int = 0,
    size: Int = 0,
    totalElements: Long = 0,
    totalPages: Int = 0
) : PageResponse<DatasourceTenant>(
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

    constructor(page: Page<DatasourceTenant>) : this(
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
        fun of(page: Page<DatasourceTenant>) = DatasourcePage(page)
    }
}