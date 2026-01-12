package com.negocil.nego_tenant.modulith.datasource.controller.response

import com.negocil.nego_tenant.modulith.tenant.controller.response.TenantResponse
import java.util.UUID

data class DatasourceResponse(
    val uuid: UUID,
    val tenant: TenantResponse,
)
