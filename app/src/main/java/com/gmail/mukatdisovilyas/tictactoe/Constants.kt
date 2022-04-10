package com.gmail.mukatdisovilyas.tictactoe

import android.content.res.Resources

class Constants
{
    companion object
    {
        val EXTRA_SIDE = "EXTRA_SIDE"
        val SIDE_X = 1
        val SIDE_CIRCLE = 0

        val USER_WIN = 1
        val ENEMY_WIN = 2
        val DRAW = 0
        val CURRENTLY_UNKNOWN = -1

        private val displayMetrics = Resources.getSystem().displayMetrics
        val SCREEN_WIDTH = displayMetrics.widthPixels
        val SCREEN_HEIGHT = displayMetrics.heightPixels

    }

}