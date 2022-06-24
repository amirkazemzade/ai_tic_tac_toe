package players

import game.Shape
import java.util.*

class Human(
    override val name: String,
    override val shape: Shape,
) : Player {

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