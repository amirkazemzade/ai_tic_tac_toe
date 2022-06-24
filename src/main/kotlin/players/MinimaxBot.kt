package players

import game.GameState
import game.Shape
import kotlin.math.max
import kotlin.math.min

/**
 * A bot player that uses minimax algorithm to play the game.
 *
 * @property name The name of the player.
 * @property shape The shape that identifies the player.
 */
class MinimaxBot(override val name: String, override val shape: Shape) : Player {
    /**
     * this function is used to get the next move from the bot
     * @param table the table with current game values
     * @return the next move position
     */
    override fun move(table: Map<Int, Shape>): Int {
        var bestScore = Int.MIN_VALUE
        var move: Int = table.filter { it.value == Shape.NONE }.keys.first()
        table.forEach { (key, value) ->
            if (value == Shape.NONE) {
                val newMap = table.toMutableMap()
                newMap[key] = shape
                val score = minmax(
                    newMap, 0, false, shape,
                    if (shape == Shape.CIRCLE) Shape.CROSS else Shape.CIRCLE
                )
                if (score > bestScore) {
                    bestScore = score
                    move = key
                }
            }
        }
        return move
    }

    /**
     * this function is used to get the best move from the bot according to the minimax algorithm
     *
     * @param table the table with current game values
     * @param depth the depth of the current node
     * @param isMaximizing true if the current player is the maximizing player, false otherwise
     * @param maximizingShape the shape of the maximizing player
     * @param minimizingShape the shape of the minimizing player
     *
     * @return the score of the current node
     */
    private fun minmax(
        table: Map<Int, Shape>,
        depth: Int,
        isMaximizing: Boolean,
        maximizingShape: Shape,
        minimizingShape: Shape,
    ): Int {
        val result = winCheck(table, maximizingShape)
        if (result != GameState.ONGOING) {
            return result.value
        }

        if (isMaximizing) {
            var bestScore = Int.MIN_VALUE

            table.forEach { (key, value) ->
                if (value == Shape.NONE) {
                    val newMap = table.toMutableMap()
                    newMap[key] = maximizingShape
                    val score = minmax(newMap, depth + 1, false, maximizingShape, minimizingShape)
                    bestScore = max(score, bestScore)
                }
            }
            return bestScore
        } else {
            var bestScore = Int.MAX_VALUE

            table.forEach { (key, value) ->
                if (value == Shape.NONE) {
                    val newMap = table.toMutableMap()
                    newMap[key] = minimizingShape
                    val score = minmax(newMap, depth + 1, true, maximizingShape, minimizingShape)
                    bestScore = min(score, bestScore)
                }
            }
            return bestScore
        }
    }

    /**
     * this function is used to check the state of game according to [GameState] states
     *
     * @param table the table with current game values
     * @param lastShape the last played shape
     *
     * @return a [GameState] which is the state of the game
     */
    private fun winCheck(table: Map<Int, Shape>, lastShape: Shape): GameState {
        if (tieCheck(table)) {
            return GameState.TIED
        }
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
                return if (shape == lastShape) {
                    GameState.WON
                } else {
                    GameState.LOST
                }
            }
        }
        return GameState.ONGOING
    }

    /**
     * this function is used to check if the game is tied
     *
     * @param table the table with current game values
     *
     * @return true if the game is tied, false otherwise
     */
    private fun tieCheck(table: Map<Int, Shape>) =
        table.filter { (_, value) -> value == Shape.NONE }.isEmpty()


}