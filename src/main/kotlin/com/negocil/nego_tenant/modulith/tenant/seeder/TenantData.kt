package com.negocil.nego_tenant.modulith.tenant.seeder

import com.negocil.nego_tenant.modulith.tenant.model.Tenant

enum class TenantData(val tenant: Tenant) {
    NETENANT(Tenant(name = "Netenant", key = "2FYndBV1LEIuOUsK6MVHOcFu8+7w2MEtKHH2n8tIJmk=", password = "12345678")),
    NEGOART(Tenant(name = "Negoart", key = "WiYIsFIszcFp6vdL867ZxZg9gkeJplRq9ywu75s7mCc=", password = "12345678")),
    NEGOCAR(Tenant(name = "Negocar", key = "JD+eJ0DuCowqGG0SvfuroraumH04Cgq33XwIWGca1wI=", password = "12345678")),
    NEGOLAR(Tenant(name = "Negolar", key = "jpwnhzilU9Q8lE4sAvMAOHYhlFayCzfyQSMOWQrPFps=", password = "12345678"))
}