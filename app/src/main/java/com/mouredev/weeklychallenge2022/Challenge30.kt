package com.mouredev.weeklychallenge2022

/*
 * Reto #30
 * MARCO DE PALABRAS
 * Fecha publicación enunciado: 26/07/22
 * Fecha publicación resolución: 01/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que reciba un texto y muestre cada palabra en una línea, formando
 * un marco rectangular de asteriscos.
 * - ¿Qué te parece el reto? Se vería así:
 *   **********
 *   * ¿Qué   *
 *   * te     *
 *   * parece *
 *   * el     *
 *   * reto?  *
 *   **********
 *
 */

fun main() {
    println(textFrame("¿Qué te parece el reto?"))
    println(textFrame("Larga vida a Compose"))
}

private fun textFrame(text: String) {
    val words = text.split(" ")
    val maxLength = "* ${words.maxBy { it.length }} *".length

    println("*".repeat(maxLength))
    for (word in text.split(" ")) {
        println("* $word${" ".repeat(maxLength - word.length - 4)} *")
    }
    println("*".repeat(maxLength))
}