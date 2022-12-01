package com.mouredev.weeklychallenge2022

/*
 * Reto #17
 * LA CARRERA DE OBSTÁCULOS
 * Fecha publicación enunciado: 25/04/22
 * Fecha publicación resolución: 02/05/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea una función que evalúe si un/a atleta ha superado correctamente una
 * carrera de obstáculos.
 * - La función recibirá dos parámetros:
 *      - Un array que sólo puede contener String con las palabras "run" o "jump"
 *      - Un String que represente la pista y sólo puede contener "_" (suelo) o "|" (valla)
 * - La función imprimirá cómo ha finalizado la carrera:
 *      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla) será correcto y no
 *        variará el símbolo de esa parte de la pista.
 *      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
 *      - Si hace "run" en "|" (valla), se variará la pista por "/".
 * - La función retornará un Boolean que indique si ha superado la carrera.
 * Para ello tiene que realizar la opción correcta en cada tramo de la pista.
 *
 */

fun main() {
    val movementsSuccess = arrayListOf(Movement.RUN, Movement.JUMP, Movement.RUN, Movement.JUMP, Movement.JUMP)
    val movementsFailure = arrayListOf(Movement.JUMP, Movement.RUN, Movement.RUN, Movement.JUMP, Movement.JUMP)
    val floor = "_|_||"

    checkRace(movementsSuccess, floor)
    checkRace(movementsFailure, floor)
}

private fun checkRace(movements: ArrayList<Movement>, floor: String) {
    val floorArray = floor.toCharArray()
    floorArray.forEachIndexed { index, char ->
        if (char == '_' && movements[index] != Movement.RUN)
            floorArray[index] = 'x'
        else if (char == '|' && movements[index] != Movement.JUMP)
            floorArray[index] = '/'
    }

    if (floorArray.contains('x') || floorArray.contains('/'))
        println("El corredor no ha superado la carrera")
    else println("El corredor ha superado la carrera con éxito")
}

enum class Movement { RUN, JUMP }