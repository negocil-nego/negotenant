package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.ConcreteModel
import org.junit.jupiter.api.Test

abstract class JpaConcreteRepoTest<T: ConcreteModel>: JpaCommonRepoTest<T>() {
    private lateinit var jpaConcreteRepo: JpaConcreteRepo<T>

    fun setRepo(jpaConcreteRepo: JpaConcreteRepo<T>) {
        this.jpaConcreteRepo = jpaConcreteRepo
        super.setRepo(jpaConcreteRepo)
    }

    @Test
    fun findByUuid_WhenDoesThrow() {

    }

    @Test
    fun deleteByUuid_WhenDoesThrow() {

    }
}