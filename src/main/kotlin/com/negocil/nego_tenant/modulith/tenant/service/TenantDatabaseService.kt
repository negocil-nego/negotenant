package com.negocil.nego_tenant.modulith.tenant.service

import com.negocil.nego_tenant.modulith.tenant.repository.TenantDatabaseRepo
import com.negocil.nego_tenant.modulith.tenant.model.Tenant
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