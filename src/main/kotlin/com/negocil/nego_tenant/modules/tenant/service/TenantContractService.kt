package com.negocil.nego_tenant.modules.tenant.service

import com.negocil.nego_tenant.shared.service.ConcreteService
import com.negocil.nego_tenant.modules.tenant.repoisitory.TenantContractRepo
import com.negocil.nego_tenant.modules.tenant.model.Tenant
import org.springframework.data.domain.Pageable

abstract class TenantContractService(
    val tenantContractRepo: TenantContractRepo
): ConcreteService<Tenant>(tenantContractRepo) {

    override fun save(data: Tenant): Tenant {
        return super.save(data)
    }

    fun findByName(name: String, pageable: Pageable) = tenantContractRepo.findByName(name, pageable)

    fun findByPassword(password: String, pageable: Pageable) = tenantContractRepo.findByPassword(password, pageable)

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