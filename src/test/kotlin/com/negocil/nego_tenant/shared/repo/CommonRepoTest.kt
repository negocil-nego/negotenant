package com.negocil.nego_tenant.shared.repo

import com.negocil.nego_tenant.shared.model.CommonModel
import org.junit.jupiter.api.Assertions.*

abstract class CommonRepoTest<T: CommonModel>{
    private lateinit var commonRepo: CommonRepo<T>

    fun setRepo(commonRepo: CommonRepo<T>) {
        this.commonRepo = commonRepo
    }

    fun findAll_WhenDoesThrow() {
        assertDoesNotThrow {
            commonRepo.findAll()
        }
    }

    fun paginate_WhenDoesThrow() {

    }

    fun save_WhenDoesThrow() {

    }

    fun delete_WhenDoesThrow() {

    }

    fun deleteAll_WhenDoesThrow() {

    }
}