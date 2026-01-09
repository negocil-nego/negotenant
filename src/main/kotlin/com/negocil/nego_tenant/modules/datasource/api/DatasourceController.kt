package com.negocil.nego_tenant.modules.datasource.api

import com.negocil.nego_tenant.modules.datasource.dto.DatasourceDto
import com.negocil.nego_tenant.modules.datasource.service.DatasourceDatabaseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("datasources")
@Tag(name = "Datasources", description = "Route for gestion of datasources")
class DatasourceController(
    private val service: DatasourceDatabaseService
) {
    @GetMapping
    @Operation(summary = "Get all datasources")
    fun findAll() = service.findAll()

    @PostMapping
    @Operation(summary = "Create datasource")
    fun save(@RequestBody @Valid datasourceDto: DatasourceDto) = service.save(datasourceDto.toModel())
}