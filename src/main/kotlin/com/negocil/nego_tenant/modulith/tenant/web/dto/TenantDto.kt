package com.negocil.nego_tenant.modulith.tenant.web.dto

import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Schema(description = "Tenant data transfer object")
data class TenantDto(
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    @Schema(description = "Tenant name", example = "NegoProject", required = true)
    val name: String,
) {
    fun toModel(): Tenant = Tenant(name)
}