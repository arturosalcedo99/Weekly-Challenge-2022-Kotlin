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

private val vowelPositions: HashMap<Char, ArrayList<Int>> = hashMapOf()

fun main() {
    println("－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－")
    println("| Karaca encryption examples | Karaca decryption examples |")

    val banana = "Banana".karacaEncryption()
    val bananaDecrypted = banana.karacaEncryption(true)
    println("| Banana --> $banana\t\t | $banana --> $bananaDecrypted\t\t  |")

    val karaca = "Karaca".karacaEncryption()
    val karacaDecrypted = karaca.karacaEncryption(true)
    println("| Karaca --> $karaca\t\t | $karaca --> $karacaDecrypted\t\t  |")

    val burak = "Burak".karacaEncryption()
    val burakDecrypted = burak.karacaEncryption(true)
    println("| Burak --> $burak\t\t | $burak --> $burakDecrypted\t\t  |")

    val alpaca = "Alpaca".karacaEncryption()
    val alpacaDecrypted = alpaca.karacaEncryption(true)
    println("| Alpaca --> $alpaca\t\t | $alpaca --> $alpacaDecrypted\t\t  |")

    val pepito = "Pepito".karacaEncryption()
    val pepitoDecrypted = pepito.karacaEncryption(true)
        println("| Pepito --> $pepito\t\t | $pepito --> $pepitoDecrypted\t\t  |")
    println("－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－")
}

private fun String.karacaEncryption(decrypt: Boolean = false): String {

    val auxCharArray =
        if (!decrypt)
            this.reversed().lowercase().toCharArray()
        else this.lowercase().removeSuffix("aca").toCharArray()

    auxCharArray.forEachIndexed { index: Int, c: Char ->
        if (!decrypt) {
            if (vowelPositions.containsKey(c))
                vowelPositions[c]?.add(index)
            else vowelPositions[c] = arrayListOf(index)
        }
        when (c) {
            'a' -> auxCharArray[index] = '0'
            'e' -> auxCharArray[index] = '1'
            'i', 'o' -> {
                auxCharArray[index] = '2'
            }
            'u' -> auxCharArray[index] = '3'
            '0' -> auxCharArray[index] = 'a'
            '1' -> auxCharArray[index] = 'e'
            '2' -> {
                auxCharArray[index] =
                    if (vowelPositions['i']?.any { it == index } == true) 'i' else 'o'
            }
            '3' -> auxCharArray[index] = 'u'
        }
    }

    return if (!decrypt)
        auxCharArray.joinToString("") + "aca"
        else auxCharArray.joinToString("")
                .reversed()
                .replaceFirstChar { it.uppercase() }
}