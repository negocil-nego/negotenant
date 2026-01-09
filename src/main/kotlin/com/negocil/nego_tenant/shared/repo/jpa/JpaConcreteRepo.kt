package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.CommonModel
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@NoRepositoryBean
interface JpaConcreteRepo<T: CommonModel>: JpaCommonRepo<T> {

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.id = :id")
    override fun deleteById(id: Long)

    @Modifying
    @Transactional
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.uuid = :uuid")
    override fun deleteByUuid(uuid: UUID)

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