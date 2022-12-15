package com.mouredev.weeklychallenge2022

/*
 * Reto #4
 * ÁREA DE UN POLÍGONO
 * Fecha publicación enunciado: 24/01/22
 * Fecha publicación resolución: 31/01/22
 * Dificultad: FÁCIL
 *
 * Enunciado: Crea UNA ÚNICA FUNCIÓN (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 *
 */

fun main() {
    Triangle(3.0, 5.0).printArea()
    Square(5.0).printArea()
    Rectangle(2.5, 6.0).printArea()
}

class Triangle(
    val height: Double,
    val base: Double
): Geometry {

    override var area = 0.0

    override fun calculateArea() {
        area = (base * height) / 2.0
    }

    override fun printArea() {
        calculateArea()
        println("El área del triángulo de altura $height y base $base es: $area")
    }
}

class Square(
    val side: Double
): Geometry {

    override var area = 0.0

    override fun calculateArea() {
        area = side * side
    }

    override fun printArea() {
        calculateArea()
        println("El área del cuadrado de lado $side es: $area")
    }
}

class Rectangle(
    val shortSide: Double,
    val longSide: Double
): Geometry {

    override var area = 0.0

    override fun calculateArea() {
        area = shortSide * longSide
    }

    override fun printArea() {
        calculateArea()
        println("El área del rectángulo de lados $shortSide y $longSide es: $area")
    }
}

interface Geometry {

    var area: Double

    fun calculateArea()
    fun printArea()
}
