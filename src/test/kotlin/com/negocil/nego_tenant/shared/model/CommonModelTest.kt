package com.negocil.nego_tenant.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class CommonModelTest(
    private var model: CommonModel
){
    @Test
    fun id_ShouldBeGreaterThanZero() {
        assertTrue(model.id > 0, "Model ID must be a positive number, but was: ${model.id}")
    }
}