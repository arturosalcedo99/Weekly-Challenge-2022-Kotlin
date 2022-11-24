package com.mouredev.weeklychallenge2022

/*
 * Reto #18
 * TRES EN RAYA
 * Fecha publicación enunciado: 02/05/22
 * Fecha publicación resolución: 09/05/22
 * Dificultad: DIFÍCIL
 *
 * Enunciado: Crea una función que analice una matriz 3x3 compuesta por "X" y "O" y retorne lo siguiente:
 * - "X" si han ganado las "X"
 * - "O" si han ganado los "O"
 * - "Empate" si ha habido un empate
 * - "Nulo" si la proporción de "X", de "O", o de la matriz no es correcta. O si han ganado los 2.
 * Nota: La matriz puede no estar totalmente cubierta. Se podría representar con un vacío "", por ejemplo.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la comunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    val matrix = arrayListOf(
        arrayListOf(' ', 'X', 'O'),
        arrayListOf('X', ' ', 'O'),
        arrayListOf('O', ' ', 'X')
    )
    print(checkTicTacToe(matrix))
}

private fun checkTicTacToe(matrix: ArrayList<ArrayList<Char>>): String {

    if(!matrix.hasCorrectDimensions())
        return "Nulo: Las dimensiones del tablero no son las esperadas."

    if(!matrix.hasCorrectPiecesProportion())
        return "Nulo: No hay una proporción correcta de X y O en el tablero."

    var victoryPieces = checkDiagonal(matrix)
    if (victoryPieces == 'X' || victoryPieces == 'O') {
        //TODO: Gestionar la victoria de las 'X' o de las 'O'
    } else {
        victoryPieces = checkLinear(matrix)
        //TODO: Comprobar si hay una victoria o no
    }

    return "Correcto"
}

//Comprueba si el tablero tiene las dimensiones esperadas
private fun ArrayList<ArrayList<Char>>.hasCorrectDimensions() =
    this.size == 3 && this.all { it.size == 3 }

//Comprueba si el tablero tiene una proporción de 'X' y 'O' dentro de lo esperado
private fun ArrayList<ArrayList<Char>>.hasCorrectPiecesProportion(): Boolean {

    val countX = this.flatten().count { it == 'X' }
    val countO = this.flatten().count { it == 'O' }

    var countDifference = countX - countO
    if(countDifference < 0) countDifference *= -1

    return countDifference in 0..1
}

//Comprueba si hay una victoria por parte de las 'X' o de las 'O' en diagonal
private fun checkDiagonal(matrix: ArrayList<ArrayList<Char>>): Char {

}

//Comprueba si hay una victoria por parte de las 'X' o de las 'O' en vertical u horizontal
private fun checkLinear(matrix: ArrayList<ArrayList<Char>>): Char {

}