package com.negocil.nego_tenant.modules.datasource.graphql

import com.negocil.nego_tenant.modules.datasource.dto.DatasourceDto
import com.negocil.nego_tenant.modules.datasource.repository.DatasourceDatabaseRepo
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.stereotype.Controller
import jakarta.validation.Valid

@Controller
class DatasourceGraphql(
    private val service: DatasourceDatabaseRepo
) {
    @QueryMapping
    fun paginateDatasource() = service.findAll()

    @MutationMapping
    fun saveDatasource(@Argument @Valid dto: DatasourceDto) = service.save(dto.toModel())
}