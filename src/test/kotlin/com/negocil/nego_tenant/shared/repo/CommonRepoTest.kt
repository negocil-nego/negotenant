package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.CommonModel
import org.junit.jupiter.api.Assertions.*

abstract class CommonRepoTest<T: CommonModel>(
  private val commonRepo: CommonRepo<T>
) {
    fun findAll_WhenDoesThrow() {
        assertDoesNotThrow {
            commonRepo.findAll()
        }
    }

    fun paginate_WhenDoesThrow() {

    }

    fun save_WhenDoesThrow() {

    }

    fun deletee_WhenDoesThrow() {

    }

    fun deleteAll_WhenDoesThrow() {

    }
}