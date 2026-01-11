package com.negocil.nego_tenant.modulith.datasource.domain.enum

enum class SgbType (val code: String, val port: Long) {
    POSTGRESQL("postgresql", 5432),
    MYSQL("mysql", 3306)
}