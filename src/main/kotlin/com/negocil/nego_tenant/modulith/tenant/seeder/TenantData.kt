package com.negocil.nego_tenant.modulith.tenant.seeder

import com.negocil.nego_tenant.modulith.tenant.model.Tenant

enum class TenantData(val tenant: Tenant) {
    NETENANT(Tenant(name = "Netenant", key = "019b9e1b-55bf-7416-8ef7-f415d852b709")),
    NEGOART(Tenant(name = "Negoart", key = "019b9e1c-660f-7dc6-9abb-3fcb0f99d171")),
    NEGOCAR(Tenant(name = "Negocar", key = "019b9e1c-dd51-7927-aef7-1c5000412da2")),
    NEGOLAR(Tenant(name = "Negolar", key = "019b9e1d-1c58-7d97-8911-e777a8f69657"))
}