package com.rodrigomirandamarenco.tictactoekotlin.viewmodel

/**
 * Created by rodrigomiranda on 11/16/17.
 * Interface used to handle lifecycle events
 */
interface ViewModel {
    fun onCreate()
    fun onPause()
    fun onResume()
    fun onDestroy()
}