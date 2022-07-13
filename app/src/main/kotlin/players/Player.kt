package players

import game.Shape

/**
 * an interface for a player. the player must have a name and an identifier shape.
 *
 * @property name the name of the player
 * @property shape the shape that identifies the player
 */
interface Player {
    val name: String
    val shape: Shape

    /**
     * this function is called when the player is asked to make a move.
     *
     *
     * @return position of the move that the player wants to make
     */
    fun move(table: Map<Int, Shape>): Int
}