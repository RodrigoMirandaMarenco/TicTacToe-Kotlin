package com.rodrigomirandamarenco.tictactoekotlin.viewmodel

import android.databinding.ObservableArrayMap
import android.databinding.ObservableField
import com.rodrigomirandamarenco.tictactoekotlin.model.Board
import com.rodrigomirandamarenco.tictactoekotlin.model.Player

/**
 * Created by rodrigomiranda on 11/16/17.
 * ViewModel used for Model-View-ViewModel Architecture
 */
class TicTacToeViewModel : ViewModel {

    val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    val winner: ObservableField<Player> = ObservableField()
    var winnerString: ObservableField<String> = ObservableField()
    private var model: Board = Board()

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {

    }

    override fun onDestroy() {

    }

    fun onResetSelected() {
        model.restart()
        winner.set(null)
        winnerString.set("")
        cells.clear()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        val playerThatMoved: Player? = model.mark(row, column)
        cells.put("" + row + column, playerThatMoved?.toString())
        winner.set(model.winner)
        winnerString.set("" + model.winner)
    }

    init {
        model = Board()
        winnerString.set("")
    }
}