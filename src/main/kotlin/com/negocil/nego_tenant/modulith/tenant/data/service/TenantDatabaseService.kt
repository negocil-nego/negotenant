package com.negocil.nego_tenant.modulith.tenant.data.service

import com.negocil.nego_tenant.modulith.tenant.data.repoisitory.TenantDatabaseRepo
import com.negocil.nego_tenant.modulith.tenant.domain.model.Tenant
import org.springframework.stereotype.Service

@Service
class TenantDatabaseService(
    tenantDatabaseRepo: TenantDatabaseRepo
): TenantContractService(tenantDatabaseRepo) {

    fun saveOrUpdate(data: Tenant): Tenant {
        val item = tenantContractRepo.findByKey(data.key)
        return if (item.isPresent) {
            data.id = item.get().id
            data.uuid = item.get().uuid
            tenantContractRepo.save(data)
        } else {
            save(data)
        }
    }

}