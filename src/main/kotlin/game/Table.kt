package game

import players.Player

/**
 * a class that represents a game of tic-tac-toe with a board of size 3x3. it receives two player two start the game with.
 *
 * @property player1 the first player
 * @property player2 the second player
 */
class Table(private val player1: Player, private var player2: Player) {
    private val table = (1..9).associateWith { Shape.NONE }.toMutableMap()

    /**
     * starts the game and asks the players to make their moves.
     */
    fun run() {
        var turn = player1
        drawTable()
        while (true) {
            move(turn.move(table), turn.shape)
            turn = if (turn == player1) player2 else player1
            drawTable()
            if (winCheck() || tieCheck()) return
        }
    }

    /**
     * checks if the game is a tie
     */
    private fun tieCheck(): Boolean {
        return table.filter { (_, value) -> value == Shape.NONE }.isEmpty().also {
            if (it) println("Tie!")
        }
    }

    /**
     * draws the game current table in the console
     */
    private fun drawTable() {
        println()
        table.forEach { (cell, shape) ->
            print(' ')
            shape.draw()
            if (cell % 3 == 0) {
                println()
                if (cell !in 7..9)
                    println("-----------")
            } else print(" |")
        }
        println()
    }

    /**
     * makes a move in the table
     */
    private fun move(pos: Int, shape: Shape) {
        if (table[pos] != Shape.NONE) throw IllegalArgumentException("Position $pos is already taken")
        table[pos] = shape
    }

    /**
     * checks if the game is won by a player
     */
    private fun winCheck(): Boolean {
        val lines = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9),
            listOf(1, 5, 9),
            listOf(3, 5, 7)
        )
        for (line in lines) {
            val shape = table[line[0]]
            if (shape != Shape.NONE && line.all { table[it] == shape }) {
                if (shape != null) {
                    printWinner(shape)
                }
                return true
            }
        }
        return false
    }

    /**
     * prints the winner of the game
     */
    private fun printWinner(shape: Shape) {
        val winner = if (player1.shape == shape) player1 else player2
        println("${winner.name} has won!")
    }
}