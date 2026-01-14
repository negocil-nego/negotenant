package com.negocil.nego_tenant.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class CommonModelTest(
    private val model: CommonModel
) {

    @Test
    fun id_valid() {
        assertTrue {  model.id > 0 }
    }

    @Test
    fun id_invalid() {
        assertTrue {  model.id < 1 }
    }

}