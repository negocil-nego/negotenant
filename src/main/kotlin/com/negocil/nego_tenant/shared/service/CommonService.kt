package com.negocil.nego_tenant.shared.service

import com.negocil.nego_tenant.config.exception.NotFoundException
import com.negocil.nego_tenant.shared.model.CommonModel
import com.negocil.nego_tenant.shared.repo.CommonRepo
import org.springframework.data.domain.Pageable
import java.util.UUID


abstract class CommonService<T: CommonModel>(
    val repository: CommonRepo<T>
) {
    open fun findAll() = repository.findAll()

    open fun findAll(paginate: Pageable) = repository.paginate(paginate)

    open fun save(data: T) = repository.save(data)

    open fun delete(data: T) = repository.delete(data)

}