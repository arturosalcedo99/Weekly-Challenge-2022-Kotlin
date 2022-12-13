package com.mouredev.weeklychallenge2022

/* Reto #50
 * LA ENCRIPTACIÓN DE KARACA
 * Fecha publicación enunciado: 12/11/22
 * Fecha publicación resolución: 19/12/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea una función que sea capaz de encriptar y desencriptar texto utilizando el
 * algoritmo de encriptación de Karaca (debes buscar información sobre él).
 *
 */

fun main() {
    println("－－－－－－－－－－－－－－－－－－")
    println("| Karaca encryption examples |")
    println("| Banana --> ${"Banana".encryptedByKaraca()}\t\t |")
    println("| Karaca --> ${"Karaca".encryptedByKaraca()}\t\t |")
    println("| Burak --> ${"Burak".encryptedByKaraca()}\t\t |")
    println("| Alpaca --> ${"Alpaca".encryptedByKaraca()}\t\t |")
    println("－－－－－－－－－－－－－－－－－－")
}

private fun String.encryptedByKaraca(): String {
    return this.reversed().lowercase()
        .replace('a', '0')
        .replace('e', '1')
        .replace('i', '2')
        .replace('o', '2')
        .replace('u', '3') + "aca"
}