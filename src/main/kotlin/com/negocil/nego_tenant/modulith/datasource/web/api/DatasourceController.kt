package com.negocil.nego_tenant.modulith.datasource.web.api

import com.negocil.nego_tenant.modulith.datasource.web.dto.DatasourceDto
import com.negocil.nego_tenant.modulith.datasource.data.service.DatasourceDatabaseService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("datasources")
@Tag(name = "Datasources", description = "Route for gestion of datasources")
class DatasourceController(
    private val service: DatasourceDatabaseService
) {

    @GetMapping
    @Operation(summary = "Get all datasources")
    fun findAll(page: Pageable) = service.paginate(page)

    @GetMapping("/{uuid}")
    @Operation(summary = "Get datasource by uuid")
    fun findByUuid(@PathVariable uuid: UUID) = service.findByUuid(uuid)

    @PostMapping
    @Operation(summary = "Create datasource")
    fun save(@RequestBody @Valid datasourceDto: DatasourceDto) = service.save(datasourceDto.toModel())

    @PutMapping("/{uuid}")
    @Operation(summary = "Update datasource")
    fun update(@PathVariable uuid: UUID, @RequestBody @Valid datasourceDto: DatasourceDto) = service.update(uuid, datasourceDto.toModel())

    @DeleteMapping("/{uuid}")
    @Operation(summary = "Delete datasource by uuid")
    fun deleteByUuid(@PathVariable uuid: UUID) = service.deleteByUuid(uuid)
}