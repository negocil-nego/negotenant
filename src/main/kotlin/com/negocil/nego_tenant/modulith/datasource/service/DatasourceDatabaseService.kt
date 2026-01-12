package com.negocil.nego_tenant.modulith.datasource.service

import com.negocil.nego_tenant.config.exception.NotFoundException
import com.negocil.nego_tenant.modulith.datasource.model.DatasourceTenant
import com.negocil.nego_tenant.modulith.datasource.repository.DatasourceDatabaseRepo
import com.negocil.nego_tenant.modulith.tenant.repository.TenantDatabaseRepo
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class DatasourceDatabaseService(
    private val datasourceRepo: DatasourceDatabaseRepo,
    private val tenantRepo: TenantDatabaseRepo
): DatasourceContractService(datasourceRepo) {

    override fun save(data: DatasourceTenant): DatasourceTenant {
        tenantRepo.findByUuid(data.tenant.uuid).ifPresentOrElse({ data.tenant = it }, {
            throw NotFoundException("Not found tenant by uuid ${data.tenant.uuid}")
        })
        return super.save(data)
    }

    fun saveOrUpdate(data: DatasourceTenant): DatasourceTenant {
        val page = datasourceRepo.findByDbname(data.dbname, PageRequest.of(0, 5))
        if (page.totalElements.toInt() == 0) return save(data);
        Optional.of(page.content[0]).ifPresent{
            data.id = it.id
            data.uuid = it.uuid
            data.tenant = it.tenant
        }
        return datasourceRepo.save(data)
    }

}