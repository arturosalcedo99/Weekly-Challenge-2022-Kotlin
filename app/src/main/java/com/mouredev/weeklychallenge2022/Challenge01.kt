package com.mouredev.weeklychallenge2022

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 */

fun main() {
    val word1 = "Jamon"
    val word2 = "Monja"
    val anagram = checkAnagram(word1, word2)
    println("Las palabras $word1 y $word2 ${if (!anagram) "no " else ""}son anagramas.")
}

private fun checkAnagram(firstWord: String, lastWord: String): Boolean {
    val word1 = firstWord.lowercase()
    val word2 = lastWord.lowercase()
    if (word1.equals(word2, true) ||
        word1.length != word2.length)
        return false

    return word1.toCharArray()
        .sortedArray()
        .contentEquals(
            word2.toCharArray()
                .sortedArray()
        )
}