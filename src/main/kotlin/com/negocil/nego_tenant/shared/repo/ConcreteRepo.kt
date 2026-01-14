package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.ConcreteModel
import java.util.Optional
import java.util.UUID

interface ConcreteRepo<T: ConcreteModel>: CommonRepo<T> {

    fun findByUuid(uuid: UUID): Optional<T>

    fun update(uuid: UUID, model: T): T

    fun deleteByUuid(uuid: UUID)

}