package com.gmail.mukatdisovilyas.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.min

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    private lateinit var imgX: ImageView
    private lateinit var imgCircle: ImageView

    private var selectedSide: Int = Constants.SIDE_X

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val minSide = min(Constants.SCREEN_HEIGHT, Constants.SCREEN_WIDTH)


        imgX = findViewById(R.id.img_dialog_x)
        imgCircle = findViewById(R.id.img_dialog_circle)

        imgX.layoutParams.height = (minSide/2.2).toInt()
        imgX.layoutParams.width = (minSide/2.2).toInt()

        imgCircle.layoutParams.height = (minSide/2.2).toInt()
        imgCircle.layoutParams.width = (minSide/2.2).toInt()

        imgX.setOnClickListener(this)
        imgCircle.setOnClickListener(this)

    }

    override fun onClick(v: View?)
    {
        when (v?.id)
        {
            R.id.img_dialog_x      ->
            {
                selectedSide = Constants.SIDE_X
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(Constants.EXTRA_SIDE, selectedSide)
                startActivity(intent)
            }
            R.id.img_dialog_circle ->
            {
                selectedSide = Constants.SIDE_CIRCLE
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(Constants.EXTRA_SIDE, selectedSide)
                startActivity(intent)
            }
        }
    }


}