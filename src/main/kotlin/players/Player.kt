package players

import game.Shape

interface Player {
    val name: String
    val shape: Shape
    fun move(table: Map<Int, Shape>): Int
}