package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.CommonModel
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.NoRepositoryBean
import java.util.UUID

@NoRepositoryBean
interface JpaConcreteRepo<T: CommonModel>: JpaCommonRepo<T> {
    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.id = :id")
    @Modifying
    override fun deleteById(id: Long)

    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e.uuid = :uuid")
    @Modifying
    override fun deleteByUuid(uuid: UUID)

    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e = :entity")
    @Modifying
    override fun delete(entity: T)

    @Query("UPDATE #{#entityName} e SET e.deleted = true")
    @Modifying
    override fun deleteAll()

    @Query("UPDATE #{#entityName} e SET e.deleted = true WHERE e IN :entities")
    @Modifying
    override fun deleteAll(entities: MutableIterable<T>)
}