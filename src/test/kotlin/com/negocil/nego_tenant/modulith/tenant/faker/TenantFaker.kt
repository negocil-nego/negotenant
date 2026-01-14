package com.negocil.nego_tenant.modulith.tenant.faker

import com.negocil.nego_tenant.modulith.tenant.model.Tenant

class TenantFaker {
    companion object {
        val model = Tenant(
            id = 10,
            name = "Negofaker",
            key = "12qemkem2ekkkererrrw",
            password = "123456"
        )
    }
}