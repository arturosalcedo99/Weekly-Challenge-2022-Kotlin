package com.mouredev.weeklychallenge2022

/*
 * Reto #45
 * CONTENEDOR DE AGUA
 * Fecha publicación enunciado: 07/10/22
 * Fecha publicación resolución: 14/11/22
 * Dificultad: MEDIA
 *
 * Enunciado: Dado un array de números enteros positivos, donde cada uno representa unidades
 * de bloques apilados, debemos calcular cuantas unidades de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *        ⏹
 *        ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades de agua.
 *   Suponemos que existe un suelo impermeable en la parte inferior que retiene el agua.
 *
 *
 * Información adicional:
 * - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
 *   para preguntas, dudas o prestar ayuda a la comunidad.
 * - Tienes toda la información sobre los retos semanales en
 *   https://retosdeprogramacion.com/semanales2022.
 *
 */

import com.mouredev.weeklychallenge2022.BlockType.*

fun main() {
    val blocks = arrayListOf(4, 0, 3, 6, 1, 3)
    countWaterDrops(blocks)
}

private fun countWaterDrops(blocks: ArrayList<Int>) {
    val maxWidth = blocks.size
    val maxHeight = blocks.max()
    val matrix = arrayListOf<ArrayList<BlockType>>()

    for (i in 0 until maxHeight) {
        val row = arrayListOf<BlockType>()
        for (j in 0 until maxWidth) {
            if (blocks[j] > 0) {
                row.add(BRICK)
                blocks[j]--
            } else {
                row.add(EMPTY_SPACE)
            }
        }
        val firstIndex = row.indexOfFirst { it == BRICK } + 1
        val lastIndex = row.indexOfLast { it == BRICK } - 1
        row.mapIndexed { index, value ->
            if (index in firstIndex..lastIndex && value == EMPTY_SPACE)
                row[index] = RAINDROP
        }
        matrix.add(i, row)
    }

    matrix.reversed().forEach { row ->
        row.forEach {
            print(
                when (it) {
                    EMPTY_SPACE -> "   "
                    BRICK -> "[*]"
                    RAINDROP -> " · "
                }
            )
        }
        println()
    }

    print("Hay un total de ${ matrix.flatten().count { it == RAINDROP } } gotas de agua")
}

enum class BlockType {
    EMPTY_SPACE,
    BRICK,
    RAINDROP
}
