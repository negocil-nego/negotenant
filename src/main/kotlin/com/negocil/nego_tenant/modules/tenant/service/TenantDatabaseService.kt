package com.negocil.nego_tenant.modules.tenant.service

import com.negocil.nego_tenant.modules.tenant.repoisitory.TenantDatabaseRepo
import org.springframework.stereotype.Service

@Service
class TenantDatabaseService(
    tenantDatabaseRepo: TenantDatabaseRepo
): TenantContractService(tenantDatabaseRepo)