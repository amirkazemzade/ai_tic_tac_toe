import game.Shape
import game.Table
import players.Human
import players.MinimaxBot

/**
 * this functions runs a game between a bot and a human player.
 */
fun main() {
    val table = Table(Human("Human", Shape.CIRCLE), MinimaxBot("ai_bot", Shape.CROSS))
    table.run()
}