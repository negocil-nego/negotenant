package com.negocil.nego_tenant.modules.datasource.service

import com.negocil.nego_tenant.config.exception.NotFoundException
import com.negocil.nego_tenant.modules.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modules.datasource.repository.DatasourceDatabaseRepo
import com.negocil.nego_tenant.modules.tenant.repoisitory.TenantDatabaseRepo
import org.springframework.stereotype.Service

@Service
class DatasourceDatabaseService(
    val datasourceRepo: DatasourceDatabaseRepo,
    val tenantRepo: TenantDatabaseRepo
): DatasourceContractService(datasourceRepo) {

    override fun save(data: DatasourceTenant): DatasourceTenant {
        tenantRepo.findByUuid(data.tenant.uuid).ifPresentOrElse({ data.tenant = it }, {
            throw NotFoundException("Not found tenant by uuid ${data.tenant.uuid}")
        })
        return super.save(data)
    }

}