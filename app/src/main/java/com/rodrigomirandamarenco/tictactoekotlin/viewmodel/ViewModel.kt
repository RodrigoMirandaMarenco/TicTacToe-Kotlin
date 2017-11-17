package com.rodrigomirandamarenco.tictactoekotlin.viewmodel

/**
 * Created by rodrigomiranda on 11/16/17.
 */
interface ViewModel {
    fun onCreate()
    fun onPause()
    fun onResume()
    fun onDestroy()
}