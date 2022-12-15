package com.mouredev.weeklychallenge2022

/*
 * Reto #0
 * EL FAMOSO "FIZZ BUZZ"
 * Fecha publicación enunciado: 27/12/21
 * Fecha publicación resolución: 03/01/22
 * Dificultad: FÁCIL
 * Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
 * - Múltiplos de 3 por la palabra "fizz".
 * - Múltiplos de 5 por la palabra "buzz".
 * - Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".
 *
 */

fun main() {
    for (i in 1..100) {
        println(
            if (i % 3 == 0 && i % 5 == 0)
                "fizzbuzz"
            else if (i % 3 == 0)
                "fizz"
            else if (i % 5 == 0)
                "buzz"
            else i
        )
    }
}