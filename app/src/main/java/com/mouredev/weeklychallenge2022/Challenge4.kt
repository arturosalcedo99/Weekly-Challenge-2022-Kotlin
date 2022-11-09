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
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {

    Triangle(10.0f, 5.0f).let {
        print(
            "Área del triángulo [Altura: ${it.height}, Base: ${it.base}] = " +
                it.calculateArea() + "\n"
        )
    }

    Square(10.0f).let {
        print(
            "Área del cuadrado [Lado: ${it.side}] = " +
                    it.calculateArea() + "\n"
        )
    }

    Rectangle(10.0f, 5.0f).let {
        print(
            "Área del rectángulo [Lado corto: ${it.shortSide}, Lado largo: ${it.longSide}] = " +
                    it.calculateArea() + "\n"
        )
    }
}

interface Polygon {
    fun calculateArea(): Float
}

class Triangle(
    val height: Float,
    val base: Float
): Polygon {

    override fun calculateArea(): Float {
        return (height * base) / 2
    }
}

class Square(
    val side: Float
): Polygon {

    override fun calculateArea(): Float {
        return side * side
    }
}

class Rectangle(
    val shortSide: Float,
    val longSide: Float
): Polygon {

    override fun calculateArea(): Float {
        return shortSide * longSide
    }
}