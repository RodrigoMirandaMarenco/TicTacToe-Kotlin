package com.rodrigomirandamarenco.tictactoekotlin.model

/**
 * Created by rodrigomiranda on 11/16/17.
 */
class Board {

    var winner: Player? = null
    lateinit var state: GameState
    lateinit var currentTurn: Player
    val cells = Array<Array<Cell?>>(3) { arrayOfNulls(3) }

    constructor()  {
        restart()
    }

    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X
        state = GameState.IN_PROGRESS
    }

    private fun clearCells() {
        for (i in 0 until cells.size) {
            for (j in 0 until cells[i].size) {
                cells[i][j] = Cell(null)
            }
        }
    }

    private fun isOutOfBounds(index: Int): Boolean = index < 0 || index > 2

    private fun isCellValueAlreadySet(row: Int, column: Int): Boolean = cells[row][column]?.value != null

    private fun isValid(row: Int, column: Int): Boolean {
        return if (state == GameState.FINISHED) {
            false
        } else if (isOutOfBounds(row) || isOutOfBounds(column)) {
            false
        } else !isCellValueAlreadySet(row, column)
    }

    private fun isWinningMoveByPlayer(player: Player, currentRow: Int, currentColumn: Int): Boolean =
        cells[currentRow][0]?.value == player && cells[currentRow][1]?.value == player && cells[currentRow][2]?.value == player ||
                cells[0][currentColumn]?.value == player && cells[1][currentColumn]?.value == player && cells[2][currentColumn]?.value == player ||
                currentRow == currentColumn && cells[0][0]?.value == player && cells[1][1]?.value == player && cells[2][2]?.value == player ||
                currentRow + currentColumn == 2 && cells[0][2]?.value == player && cells[1][1]?.value == player && cells[2][0]?.value == player

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn == Player.X) Player.O else Player.X
    }

    fun mark(row: Int, column: Int): Player? {
        var playerThatMoved: Player? = null
        if (isValid(row, column)) {
            cells[row][column]?.value = currentTurn
            playerThatMoved = currentTurn

            if (isWinningMoveByPlayer(currentTurn, row, column)) {
                state = GameState.FINISHED
                winner = currentTurn
            } else {
                flipCurrentTurn()
            }
        }
        return playerThatMoved
    }

    fun valueAtCell(row: Int, column: Int): Player? = cells[row][column]?.value

}
