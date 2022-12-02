package com.mouredev.weeklychallenge2022

/*
 * Reto #28
 * MÁQUINA EXPENDEDORA
 * Fecha publicación enunciado: 11/07/22
 * Fecha publicación resolución: 18/07/22
 * Dificultad: MEDIA
 *
 * Enunciado: Simula el funcionamiento de una máquina expendedora creando una operación
 * que reciba dinero (array de monedas) y un número que indique la selección del producto.
 * - El programa retornará el nombre del producto y un array con el dinero de vuelta (con el menor
 *   número de monedas).
 * - Si el dinero es insuficiente o el número de producto no existe, deberá indicarse con un mensaje
 *   y retornar todas las monedas.
 * - Si no hay dinero de vuelta, el array se retornará vacío.
 * - Para que resulte más simple, trabajaremos en céntimos con monedas de 5, 10, 50, 100 y 200.
 * - Debemos controlar que las monedas enviadas estén dentro de las soportadas.
 *
 */

fun main() {
    calculateChange(arrayListOf(MONEY.COIN_10, MONEY.COIN_100, MONEY.COIN_5, MONEY.COIN_50), PRODUCT.ONIGIRI)
    calculateChange(arrayListOf(MONEY.COIN_50, MONEY.COIN_100), PRODUCT.TAKOYAKI)
    calculateChange(arrayListOf(MONEY.COIN_200, MONEY.COIN_10, MONEY.COIN_5), PRODUCT.RAMUNE)
}

private fun calculateChange(coins: ArrayList<MONEY>, product: PRODUCT) {
    val change = coins.calculateTotal() - product.price
    println("Producto seleccionado: ${product.productName}")
    if (change < 0) {
        println("Monedas insuficientes")
        println("Cambio: " + coins.map { it.value })
    } else {
        println("Cambio: " + change.calculateMinimumChange().map { it.value })
    }
    println()
}

private fun ArrayList<MONEY>.calculateTotal(): Int {
    var totalAmount = 0
    forEach {
        totalAmount += it.value
    }
    return totalAmount
}

private fun Int.calculateMinimumChange(): ArrayList<MONEY> {
    var price = this
    var divider = MONEY.values().last()
    val change = arrayListOf<MONEY>()
    while (price > 0) {
        if (price - divider.value >= 0) {
            price -= divider.value
            change.add(divider)
        }
        else {
            val nextIndex = MONEY.values().indexOf(divider) - 1
            divider = MONEY.values()[nextIndex]
        }
    }
    return change
}

enum class MONEY(val value: Int) {
    COIN_5(5),
    COIN_10(10),
    COIN_50(50),
    COIN_100(100),
    COIN_200(200)
}

enum class PRODUCT(val price: Int, val productName: String) {
    TAKOYAKI(150, "Takoyaki"),
    RAMUNE(50, "Ramune"),
    ONIGIRI(100, "Onigiri")
}