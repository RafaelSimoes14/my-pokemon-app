package com.example.mypokemonapp.util.extensions

fun formatPokemonMeasurement(value: Long?, isHeight: Boolean): String {
    val convertedValue = value?.div(10.0)
    return "%.1f ${if (isHeight) "m" else "kg"}".format(convertedValue)
}