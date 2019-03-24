package hu.martontoth.auth

import java.util.*

fun <T> Optional<T>.unwrap(): T? =
        this.orElse(null)
