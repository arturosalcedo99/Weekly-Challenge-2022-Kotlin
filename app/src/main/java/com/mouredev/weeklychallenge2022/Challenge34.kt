package com.mouredev.weeklychallenge2022

import java.lang.Exception

/*
 * Reto #34
 * LOS NÚMEROS PERDIDOS
 * Fecha publicación enunciado: 22/08/22
 * Fecha publicación resolución: 29/08/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Dado un array de enteros ordenado y sin repetidos, crea una función que calcule
 * y retorne todos los que faltan entre el mayor y el menor.
 * - Lanza un error si el array de entrada no es correcto.
 *
 */

fun main() {
    try {
        var array = arrayListOf(1, 3, 7)
        println("Números perdidos en $array: ${findLostNumbers(array)}")

        array = arrayListOf(-5, 1, 6, -2)
        println("Números perdidos en $array: ${findLostNumbers(array)}")

        array = arrayListOf(2)
    } catch (e: Exception) {
        println("El array de números no es correcta")
    }
}

private fun findLostNumbers(array: ArrayList<Int>): ArrayList<Int> {
    val maxNumber = array.max()
    val minNumber = array.min()
    val lostNumbers = arrayListOf<Int>()

    if (array.size < 2)
        throw Exception()

    for (i in minNumber until maxNumber) {
        if (!array.contains(i))
            lostNumbers.add(i)
    }
    return lostNumbers
}