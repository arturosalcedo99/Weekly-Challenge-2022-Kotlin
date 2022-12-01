package com.mouredev.weeklychallenge2022

/*
 * Reto #26
 * CUADRADO Y TRIÁNGULO 2D
 * Fecha publicación enunciado: 27/06/22
 * Fecha publicación resolución: 07/07/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea un programa que dibuje un cuadrado o un triángulo con asteriscos "*".
 * - Indicaremos el tamaño del lado y si la figura a dibujar es una u otra.
 * - EXTRA: ¿Eres capaz de dibujar más figuras?
 *
 */

fun main() {
    drawPolygon(10, Polygon.SQUARE)
    drawPolygon(10, Polygon.TRIANGLE)
}

private fun drawPolygon(side: Int, type: Polygon) {
    when (type) {
        Polygon.SQUARE -> {
            for (i in 0 until side) {
                for (j in 0 until side) {
                    if (i != 0 && i != side - 1) {
                        if (j == 0 || j == side - 1)
                            print("*  ")
                        else print("   ")
                    } else {
                        print("*  ")
                    }
                }
                println()
            }
        }
        Polygon.TRIANGLE -> {
            for (i in 0 until side) {
                if (i == 0)
                    println("*")
                else if (i == side - 1)
                    repeat(side) { print("*  ") }
                else {
                    for (j in 0..i + 1) {
                        if (i != side - 1) {
                            if (j == 0 || j == i)
                                print("*  ")
                            else print("   ")
                        } else print("*  ")
                    }
                    println()
                }
            }
        }
    }
    println()
}

enum class Polygon { SQUARE, TRIANGLE }