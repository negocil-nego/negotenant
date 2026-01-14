package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.CommonModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional
import java.util.UUID

interface CommonRepo<T: CommonModel> {
    fun findAll(): List<T>

    fun paginate(pageable: Pageable): Page<T>

    fun save(model: T): T

    fun delete(model: T): Unit

    fun deleteAll()

    fun deleteAll(entities: MutableIterable<T>)
}