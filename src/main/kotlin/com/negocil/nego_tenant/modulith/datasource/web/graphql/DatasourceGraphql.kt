package com.negocil.nego_tenant.modulith.datasource.web.graphql

import com.negocil.nego_tenant.modulith.datasource.data.service.DatasourceDatabaseService
import com.negocil.nego_tenant.modulith.datasource.web.dto.DatasourceDto
import com.negocil.nego_tenant.modulith.datasource.domain.model.DatasourceTenant
import com.negocil.nego_tenant.shared.util.PaginateDto
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.stereotype.Controller
import jakarta.validation.Valid
import java.util.UUID

@Controller
class DatasourceGraphql(
    private val service: DatasourceDatabaseService
) {
    @QueryMapping
    fun findByUuidDatasource(@Argument uuid: String) = service.findByUuid(UUID.fromString(uuid))

    @QueryMapping
    fun paginateDatasource(@Argument paginateDto: PaginateDto) = service.paginate(paginateDto)

    @MutationMapping
    fun saveDatasource(@Argument @Valid datasourceDto: DatasourceDto) = service.save(datasourceDto.toModel())

    @MutationMapping
    fun updateDatasource(@Argument uuid: String, @Argument @Valid datasourceDto: DatasourceDto): DatasourceTenant {
        return service.update(UUID.fromString(uuid), datasourceDto.toModel())
    }

    @MutationMapping
    fun deleteByUuidDatasource(@Argument uuid: String): Boolean {
        service.deleteByUuid(UUID.fromString(uuid))
        return true
    }
}