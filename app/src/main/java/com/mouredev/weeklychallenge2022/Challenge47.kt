package com.mouredev.weeklychallenge2022

import android.content.res.Resources
import android.icu.text.PluralFormat

/*
 * Reto #47
 * VOCAL MÁS COMÚN
 * Fecha publicación enunciado: 21/11/22
 * Fecha publicación resolución: 28/11/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un función que reciba un texto y retorne la vocal que más veces se repita.
 * Si no hay vocales podrá devolver vacío.
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

fun main() {
    countVocals("Hola mundo")
    countVocals("Ornitorrinco")
}

private fun countVocals(text: String) {
    val vocalsCount = hashMapOf(
        'a' to 0,
        'e' to 0,
        'i' to 0,
        'o' to 0,
        'u' to 0
    )
    text.lowercase().forEach {
        if (vocalsCount.containsKey(it)) {
            vocalsCount[it] = vocalsCount[it]?.plus(1) ?: 0
        }
    }

    vocalsCount.filter { it.value == vocalsCount.values.max() }.apply {
        when (this.size) {
            0 -> println("No hay vocales en la cadena de texto introducida")
            1 -> println("La vocal que más aparece es ${keys.first()} con ${values.first()} repeticiones")
            else -> println("Las vocales que más aparecen son ${keys.toList()} con ${values.max()} repeticiones")
        }
    }
}