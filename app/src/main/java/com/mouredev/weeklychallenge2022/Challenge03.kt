package com.mouredev.weeklychallenge2022

/*
 * Reto #3
 * ¿ES UN NÚMERO PRIMO?
 * Fecha publicación enunciado: 17/01/22
 * Fecha publicación resolución: 24/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 *
 */

fun main() {
    (1..100).filter { it.isPrime() }.onEach { println(it) }
}

private fun Int.isPrime(): Boolean {
    if (this < 2)
        return false
    for (i in 2 until this)
        if (this % i == 0)
            return false
    return true
}