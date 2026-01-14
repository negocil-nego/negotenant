package com.negocil.nego_tenant.shared.service

import com.negocil.nego_tenant.config.exception.NotFoundException
import com.negocil.nego_tenant.shared.contracts.SoftDeleteFieldUnique
import com.negocil.nego_tenant.shared.repo.ConcreteRepo
import com.negocil.nego_tenant.shared.model.ConcreteModel
import java.util.UUID

abstract class ConcreteService<T: ConcreteModel>(
    val concreteRepository: ConcreteRepo<T>
): CommonService<T>(concreteRepository) {
    open fun findByUuid(uuid: UUID): T = concreteRepository.findByUuid(uuid).orElseThrow { NotFoundException("") }

    open fun update(uuid: UUID, data: T) = concreteRepository.update(uuid, data)

    open fun deleteByUuid(uuid: UUID) = concreteRepository.deleteByUuid(uuid)

    override fun delete(data: T) {
        if(data is SoftDeleteFieldUnique) data.preSoftDeleteFieldUnique();
        super.delete(data)
    }
}