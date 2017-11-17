package com.rodrigomirandamarenco.tictactoekotlin.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.rodrigomirandamarenco.tictactoekotlin.R
import com.rodrigomirandamarenco.tictactoekotlin.databinding.ActivityMainBinding
import com.rodrigomirandamarenco.tictactoekotlin.viewmodel.TicTacToeViewModel

class MainActivity : AppCompatActivity() {

    var viewModel = TicTacToeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.viewModel = viewModel
        viewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_reset -> {
                viewModel.onResetSelected()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
