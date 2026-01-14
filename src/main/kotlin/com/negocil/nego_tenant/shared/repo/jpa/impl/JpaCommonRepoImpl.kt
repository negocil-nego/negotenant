package com.negocil.nego_tenant.shared.repo.jpa.impl

import com.negocil.nego_tenant.shared.model.CommonModel
import com.negocil.nego_tenant.shared.repo.CommonRepo
import com.negocil.nego_tenant.shared.repo.jpa.JpaConcreteRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

abstract class JpaCommonRepoImpl<T: CommonModel>(
    private val repo: JpaConcreteRepo<T>
): CommonRepo<T> {

    override fun findAll(): List<T> = repo.findAll()

    override fun paginate(pageable: Pageable): Page<T> = repo.findAll(pageable)

    override fun save(model: T): T = repo.save(model)

    override fun delete(model: T) = repo.delete(model)

    override fun deleteAll() = repo.deleteAll()

    override fun deleteAll(entities: MutableIterable<T>) = repo.deleteAll()

}