package com.negocil.nego_tenant.shared.contracts

interface SeederRun<T> {
    fun run()
    fun items(): List<T> = emptyList()
}