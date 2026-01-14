package com.negocil.nego_tenant.shared.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

abstract class ConcreteModelTest(
    private val model: ConcreteModel
): CommonModelTest(model) {

    @Test
    fun uuid_ShouldBeVersionGreaterOrEqualThanFour() {
        print(model.uuid.version())
        assertTrue {  model.uuid.version() > 3 }
    }

}