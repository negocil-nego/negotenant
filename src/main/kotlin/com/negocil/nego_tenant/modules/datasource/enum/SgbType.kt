package com.negocil.nego_tenant.modules.datasource.enum

enum class SgbType (val code: String, val port: Long) {
    POSTGRESQL("postgresql", 5432),
    MYSQL("mysql", 3306)
}