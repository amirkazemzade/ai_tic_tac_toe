import game.Shape
import game.Table
import players.Human
import players.MinimaxBot

fun main() {
    val table = Table(Human("Human", Shape.CIRCLE), MinimaxBot("ai_bot", Shape.CROSS))
    table.run()
}