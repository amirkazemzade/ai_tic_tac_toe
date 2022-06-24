import players.RandomBot
import game.Shape
import game.Table

fun main(){
    val table = Table(RandomBot("bot1", Shape.CROSS), RandomBot("bot2", Shape.CIRCLE))
    table.run()
}