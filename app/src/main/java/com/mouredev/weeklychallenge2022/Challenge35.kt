package com.mouredev.weeklychallenge2022

import kotlin.math.roundToInt

/*
 * Reto #35
 * BATALLA POKÉMON
 * Fecha publicación enunciado: 29/08/22
 * Fecha publicación resolución: 06/09/22
 * Dificultad: MEDIA
 *
 * Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
 * - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
 * - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
 * - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
 * - El programa recibe los siguientes parámetros:
 *  - Tipo del Pokémon atacante.
 *  - Tipo del Pokémon defensor.
 *  - Ataque: Entre 1 y 100.
 *  - Defensa: Entre 1 y 100.
 *
 */

fun main() {
    var pokemon1 = Pokemon.PIKACHU
    var pokemon2 = Pokemon.SQUIRTLE
    println("El daño que recibirá ${pokemon2.pokemonName} " +
            "del ataque de ${pokemon1.pokemonName} es de " +
            "${calculateDamage(pokemon1, pokemon2)} PS")

    pokemon1 = Pokemon.BULBASAUR
    pokemon2 = Pokemon.CHARMANDER
    println("El daño que recibirá ${pokemon2.pokemonName} " +
            "del ataque de ${pokemon1.pokemonName} es de " +
            "${calculateDamage(pokemon1, pokemon2)} PS")

    pokemon1 = Pokemon.PIKACHU
    pokemon2 = Pokemon.CHARMANDER
    println("El daño que recibirá ${pokemon2.pokemonName} " +
            "del ataque de ${pokemon1.pokemonName} es de " +
            "${calculateDamage(pokemon1, pokemon2)} PS")
}

private fun calculateDamage(pokemon1: Pokemon, pokemon2: Pokemon): Int {
    var damage = 0
    val effectiveness: Float
    when (pokemon2.type) {
        Type.WATER -> {
            effectiveness = when (pokemon1.type) {
                                Type.ELECTRIC, Type.GRASS -> 2f
                                else -> 0.5f
                            }
        }
        Type.FIRE -> {
            effectiveness = when (pokemon1.type) {
                                Type.WATER -> 2f
                                Type.GRASS -> 0.5f
                                else -> 1f
                            }
        }
        Type.GRASS -> {
            effectiveness = when (pokemon1.type) {
                                Type.FIRE -> 2f
                                else -> 0.5f
                            }
        }
        Type.ELECTRIC -> effectiveness = 1f
    }
    damage = (50 * pokemon1.attack / pokemon2.defense * effectiveness).roundToInt()
    if (damage <= 0) damage = 1
    return damage
}

enum class Type(val value: String) {
    WATER("Agua"),
    FIRE("Fuego"),
    GRASS("Planta"),
    ELECTRIC("Eléctrico")
}

enum class Pokemon(val type: Type, val attack: Int, val defense: Int, val pokemonName: String) {
    SQUIRTLE(Type.WATER, 63, 65, "Squirtle"),
    CHARMANDER(Type.FIRE, 65, 61, "Charmander"),
    BULBASAUR(Type.GRASS, 65, 63, "Bulbasaur"),
    PIKACHU(Type.ELECTRIC, 63, 59, "Pikachu")
}