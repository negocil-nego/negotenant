package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.CommonModel
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional
import java.util.Optional
import java.util.UUID

@NoRepositoryBean
interface JpaConcreteRepo<T: CommonModel>: JpaCommonRepo<T> {
    fun findByUuid(uuid: UUID): Optional<T>

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.uuid = :uuid")
    fun deleteByUuid(uuid: UUID)

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e = :entity")
    override fun delete(entity: T)

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true")
    override fun deleteAll()

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e IN :entities")
    override fun deleteAll(entities: MutableIterable<T>)
}