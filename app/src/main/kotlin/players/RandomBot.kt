package players

import game.Shape

class RandomBot(override val name: String, override val shape: Shape) : Player {

    override fun move(table: Map<Int, Shape>) =
        table.filter { it.value == Shape.NONE }.keys.random()

}