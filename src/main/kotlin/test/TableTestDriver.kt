import players.Player
import game.Shape
import game.Table
import players.Human

fun main() {
    tableTest()
}

fun tableTest() {
    val stubPlayer1 = Human("ali", Shape.CROSS)
    val stubPlayer2 = Human("reza", Shape.CIRCLE)
    Table(stubPlayer1, stubPlayer2).run()
}