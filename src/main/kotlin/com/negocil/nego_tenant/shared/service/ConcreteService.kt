package com.negocil.nego_tenant.shared.service

import com.negocil.nego_tenant.shared.contracts.SoftDeleteFieldUnique
import com.negocil.nego_tenant.shared.repo.ConcreteRepo
import com.negocil.nego_tenant.shared.model.ConcreteModel

abstract class ConcreteService<T: ConcreteModel>(
    concreteRepository: ConcreteRepo<T>
): CommonService<T>(concreteRepository) {
    override fun delete(data: T) {
        if(data is SoftDeleteFieldUnique) data.preSoftDeleteFieldUnique();
        super.delete(data)
    }
}