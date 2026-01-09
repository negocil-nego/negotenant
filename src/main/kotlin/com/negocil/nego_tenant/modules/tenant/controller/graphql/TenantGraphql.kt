package com.negocil.nego_tenant.modules.tenant.controller.graphql

import com.negocil.nego_tenant.modules.tenant.service.TenantDatabaseService
import com.negocil.nego_tenant.modules.tenant.controller.dto.TenantDto
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.stereotype.Controller
import jakarta.validation.Valid

@Controller
class TenantGraphql(
    private val service: TenantDatabaseService
) {
    @QueryMapping
    fun paginateTenant() = service.findAll()

    @MutationMapping
    fun saveTenant(@Argument @Valid dto: TenantDto) = service.save(dto.toModel())
}