package com.negocil.nego_tenant.modules.tenant.controller.response

import com.negocil.nego_tenant.modules.tenant.model.Tenant
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import java.util.UUID

data class TenantResponse(
    val name: String,
    val uuid: UUID
) {
    companion object {
        fun toMapper(list: List<Tenant>) = list.map { it.toResponse() }

        fun toMapper(page: Page<Tenant>): Page<TenantResponse> {
            val data = toMapper(page.content)
            return PageImpl(data, page.pageable, page.totalElements)
        }
    }
}