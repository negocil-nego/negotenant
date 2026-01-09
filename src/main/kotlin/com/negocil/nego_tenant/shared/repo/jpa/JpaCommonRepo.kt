package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.CommonModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean
import java.util.Optional
import java.util.UUID

@NoRepositoryBean
interface JpaCommonRepo<T: CommonModel>: JpaRepository<T, Long> {
    fun findByUuid(uuid: UUID): Optional<T>

    fun deleteByUuid(uuid: UUID)
}