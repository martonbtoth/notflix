package hu.martontoth.metadata

import java.util.*

fun <T> Optional<T>.unwrap(): T? =
        this.orElse(null)
