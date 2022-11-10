package com.mouredev.weeklychallenge2022

/*
 * Reto #7
 * CONTANDO PALABRAS
 * Fecha publicación enunciado: 14/02/22
 * Fecha publicación resolución: 21/02/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que cuente cuantas veces se repite cada palabra y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que lo resuelvan automáticamente.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    "Hola, mi nombre es brais. Mi nombre completo es Brais Moure (MoureDev).".countWords()
}

private fun String.countWords() {

    var wordsCount: HashMap<String, Int> = hashMapOf()
    var wordsNumber: Int = 0

    this.replace("[\\p{P}\\p{S}]".toRegex(), " ").lowercase().split(" ").forEach {
        if (wordsCount.containsKey(it))
            wordsCount[it] = wordsCount.getValue(it) + 1
        else
            wordsCount[it] = 1
    }

    wordsCount = wordsCount.toList()
        .sortedBy { (key, _) -> key }
        .sortedByDescending { (_, value) -> value }
        .toMap() as HashMap<String, Int>

    wordsCount.forEach { (word, count) ->
        if (word.isNotEmpty() && word != " ") {
            print("${word.replaceFirstChar { it.uppercase() }}: $count\n")
            wordsNumber += count
        }
    }

    print("Total de palabras: $wordsNumber")
}

