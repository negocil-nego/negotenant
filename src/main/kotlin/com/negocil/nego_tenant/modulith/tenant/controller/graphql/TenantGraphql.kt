package com.negocil.nego_tenant.modulith.tenant.controller.graphql

import com.negocil.nego_tenant.modulith.tenant.service.TenantDatabaseService
import com.negocil.nego_tenant.modulith.tenant.controller.dto.TenantDto
import com.negocil.nego_tenant.modulith.tenant.model.Tenant
import com.negocil.nego_tenant.shared.util.PaginateDto
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.stereotype.Controller
import jakarta.validation.Valid
import java.util.UUID

@Controller
class TenantGraphql(
    private val service: TenantDatabaseService
) {

    @QueryMapping
    fun findByUuidTenant(@Argument uuid: String) = service.findByUuid(UUID.fromString(uuid))

    @QueryMapping
    fun paginateTenant(@Argument paginateDto: PaginateDto) = service.paginate(paginateDto)

    @MutationMapping
    fun saveTenant(@Argument @Valid tenantDto: TenantDto) = service.save(tenantDto.toModel())

    @MutationMapping
    fun updateTenant(@Argument uuid: String, @Argument @Valid tenantDto: TenantDto): Tenant {
        return service.update(UUID.fromString(uuid), tenantDto.toModel())
    }

    @MutationMapping
    fun deleteByUuidTenant(@Argument uuid: String): Boolean {
        service.deleteByUuid(UUID.fromString(uuid))
        return true
    }
}