package com.negocil.nego_tenant.shared.util

import java.io.Serializable

open class PageResponse<T>(
    val content: List<T> = emptyList<T>(),
    val empty: Boolean = false,
    val first: Boolean = false,
    val last: Boolean = false,
    val number: Int = 0,
    val numberOfElements: Int = 0,
    val size: Int = 0,
    val totalElements: Long = 0L,
    val totalPages: Int = 0
): Serializable