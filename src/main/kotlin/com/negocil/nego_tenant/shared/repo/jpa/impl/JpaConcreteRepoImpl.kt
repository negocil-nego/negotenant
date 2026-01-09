package com.negocil.nego_tenant.shared.repo.jpa.impl

import com.negocil.nego_tenant.config.exception.NotFoundException
import com.negocil.nego_tenant.shared.model.ConcreteModel
import com.negocil.nego_tenant.shared.repo.ConcreteRepo
import com.negocil.nego_tenant.shared.repo.jpa.JpaConcreteRepo
import org.springframework.data.domain.Pageable
import java.util.UUID

abstract class JpaConcreteRepoImpl<T: ConcreteModel>(
    private val repo: JpaConcreteRepo<T>
): ConcreteRepo<T> {

    override fun findAll() = repo.findAll()

    override fun paginate(pageable: Pageable) = repo.findAll(pageable)

    override fun findByUuid(uuid: UUID) = repo.findByUuid(uuid)

    override fun save(model: T): T = repo.save(model)

    override fun delete(model: T) = repo.delete(model)

    override fun deleteByUuid(uuid: UUID) = repo.deleteByUuid(uuid)

    override fun deleteAll() = repo.deleteAll()

    override fun deleteAll(entities: MutableIterable<T>) = repo.deleteAll()

    override fun update(uuid: UUID, model: T): T {
        findByUuid(uuid).ifPresentOrElse({ model.id = it.id }, {
            throw NotFoundException("Not found ${model.javaClass.simpleName} by uuid $uuid")
        })
        return save(model)
    }
}