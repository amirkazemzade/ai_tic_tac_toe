package players

import game.Shape
import java.util.*

/**
 * this class is the player that is controlled by the user
 *
 * @property name the name of the player
 * @property shape the shape that identifies the player
 */
class Human(
    override val name: String,
    override val shape: Shape,
) : Player {
    /**
     * this function is used to get the next move from the user
     *
     * @param table the table with current game values
     * @return the next move position
     */
    override fun move(table: Map<Int, Shape>): Int {
        val availableMoves = table.filter { it.value == Shape.NONE }.keys
        if (availableMoves.isEmpty()) {
            throw IllegalStateException("No moves available")
        }
        if (availableMoves.size == 1) {
            return availableMoves.first()
        }
        val reader = Scanner(System.`in`)
        while (true) {
            print("${name}:")
            val pos = reader.nextInt()
            if (pos < 1 || pos > 9) {
                println("invalid")
                continue
            }
            if (!availableMoves.contains(pos)) {
                println("taken")
                continue
            }
            return pos
        }
    }
}