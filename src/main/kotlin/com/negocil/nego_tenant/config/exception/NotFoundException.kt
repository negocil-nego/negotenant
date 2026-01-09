package com.negocil.nego_tenant.config.exception

class NotFoundException(
    message: String,
    cause: Throwable? = null
) : RuntimeException(message, cause) {

}