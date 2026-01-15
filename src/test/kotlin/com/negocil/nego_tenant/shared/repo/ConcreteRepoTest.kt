package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.ConcreteModel

abstract class ConcreteRepoTest<T: ConcreteModel>: CommonRepoTest<T>() {
    private lateinit var concreteRepo: ConcreteRepo<T>

    fun setRepo(concreteRepo: ConcreteRepo<T>) {
        super.setRepo(concreteRepo)
        this.concreteRepo = concreteRepo
    }

    fun findByUuid_WhenDoesThrow() {

    }

    fun update_WhenDoesThrow() {

    }

    fun deleteByUuid_WhenDoesThrow() {

    }

}