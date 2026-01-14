package com.negocil.nego_tenant.shared.repo.jpa

import com.negocil.nego_tenant.shared.model.CommonModel
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class JpaCommonRepoTest<T: CommonModel>{
    private lateinit var jpaCommonRepo: JpaCommonRepo<T>

    fun setRepo(jpaCommonRepo: JpaCommonRepo<T>) {
        this.jpaCommonRepo = jpaCommonRepo
    }

}