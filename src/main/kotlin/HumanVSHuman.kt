import game.Shape
import game.Table
import players.Human
import java.util.*

/**
 * this function runs a game between two Human players
 */
fun main() {
    val reader = Scanner(System.`in`)
    print("player 1 name with shape X: ")
    val name1 = reader.next()
    print("player 2 name with shape O: ")
    val name2 = reader.next()
    val table = Table(Human(name1, Shape.CROSS), Human(name2, Shape.CIRCLE))
    table.run()
}