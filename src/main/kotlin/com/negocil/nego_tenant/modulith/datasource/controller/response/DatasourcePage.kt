package com.negocil.nego_tenant.modulith.datasource.controller.response

import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.shared.util.PageResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest

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

    fun toResponse(): Page<DatasourceResponse> {
        val list = content.map { it.toResponse() }
        val pageable = PageRequest.of(number, if (size > 0) size else 1)
        return PageImpl(list, pageable, totalElements )
    }

}