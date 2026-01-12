package com.negocil.nego_tenant.modulith.tenant.controller.response

import java.util.UUID

data class TenantResponse(
    val uuid: UUID,
    val name: String,
)