package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.ConcreteModel

abstract class ConcreteRepoTest<T: ConcreteModel>(
    concreteRepo: ConcreteRepo<T>
): CommonRepoTest<T>(concreteRepo) {

    fun findByUuid_WhenDoesThrow() {

    }

    fun update_WhenDoesThrow() {

    }

    fun deleteByUuid_WhenDoesThrow() {

    }

}