package com.mouredev.weeklychallenge2022

/*
 * Reto #33
 * CICLO SEXAGENARIO CHINO
 * Fecha publicación enunciado: 15/08/22
 * Fecha publicación resolución: 22/08/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un función, que dado un año, indique el elemento y animal correspondiente
 * en el ciclo sexagenario del zodíaco chino.
 * - Información: https://www.travelchinaguide.com/intro/astrology/60year-cycle.htm
 * - El ciclo sexagenario se corresponde con la combinación de los elementos madera,
 *   fuego, tierra, metal, agua y los animales rata, buey, tigre, conejo, dragón, serpiente,
 *   caballo, oveja, mono, gallo, perro, cerdo (en este orden).
 * - Cada elemento se repite dos años seguidos.
 * - El último ciclo sexagenario comenzó en 1984 (Madera Rata).
 *
 */

fun main() {
    for (i in 1984..2043)
        println(checkChineseZodiac(i))
}

private fun checkChineseZodiac(year: Int): String {
    var element = ELEMENT.values().first()
    var animal = ANIMAL.values().first()
    var rest = year % 60 - 4
    if (rest < 0) rest += 60
    for (i in 0 until rest) {
        if (i % 2 != 0 && i > 0) {
            val elementIndex = ELEMENT.values().indexOf(element)
            element = if (elementIndex < ELEMENT.values().size - 1) {
                ELEMENT.values()[elementIndex + 1]
            } else {
                ELEMENT.values().first()
            }
        }
        val animalIndex = ANIMAL.values().indexOf(animal)
        animal = if (animalIndex < ANIMAL.values().size - 1) {
            ANIMAL.values()[animalIndex + 1]
        } else {
            ANIMAL.values().first()
        }
    }
    return "$year: [${element.name}, ${animal.name}]"
}

enum class ELEMENT {
    WOOD, FIRE, EARTH, METAL, WATER
}

enum class ANIMAL {
    RAT, OX, TIGER, BUNNY, DRAGON, SNAKE, HORSE, SHEEP, MONKEY, ROOSTER, DOG, PIG
}