package com.negocil.nego_tenant.modulith.tenant.controller.rest

import com.negocil.nego_tenant.modulith.tenant.service.TenantDatabaseService
import com.negocil.nego_tenant.modulith.tenant.controller.dto.TenantDto
import org.springframework.web.bind.annotation.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import java.util.UUID

@RestController
@RequestMapping("tenants")
@Tag(name = "Tenants", description = "Route for gestion of tenants")
class TenantController(private val service: TenantDatabaseService) {

    @GetMapping
    @Operation(summary = "Get all tenants")
    fun findAll(page: Pageable) = service.paginate(page)

    @GetMapping("/{uuid}")
    @Operation(summary = "Get tenant by uuid")
    fun findByUuid(@PathVariable uuid: UUID) = service.findByUuid(uuid)

    @PostMapping
    @Operation(summary = "Create tenant")
    fun save(@RequestBody @Valid tenantDto: TenantDto) = service.save(tenantDto.toModel())

    @PutMapping("/{uuid}")
    @Operation(summary = "Update tenant")
    fun update(@PathVariable uuid: UUID, @RequestBody @Valid tenantDto: TenantDto) = service.update(uuid, tenantDto.toModel())

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete tenant by uuid")
    fun deleteByUuid(@PathVariable uuid: UUID) = service.deleteByUuid(uuid)
}