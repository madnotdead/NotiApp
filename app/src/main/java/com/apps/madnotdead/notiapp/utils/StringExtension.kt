package com.apps.madnotdead.notiapp.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.*

/**
 * Created by madnotdead on 7/30/17.
 */
fun String.toDateWithFormat(currentFormat: String, newFormat: String): String {
    val simpleFormat = SimpleDateFormat(currentFormat, getDefault())
    val newSimpleFormat = SimpleDateFormat(newFormat, getDefault())
    return newSimpleFormat.format(simpleFormat.parse(this))
}