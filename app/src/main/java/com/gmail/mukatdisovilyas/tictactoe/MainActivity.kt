package com.gmail.mukatdisovilyas.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener
{
    private lateinit var imgX: ImageView
    private lateinit var imgCircle: ImageView

    private var selectedSide: Int = Constants.SIDE_X

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgX = findViewById(R.id.img_dialog_x)
        imgCircle = findViewById(R.id.img_dialog_circle)

        imgX.setOnClickListener(this)
        imgCircle.setOnClickListener(this)

    }

    override fun onClick(v: View?)
    {
        when (v?.id)
        {
            R.id.img_dialog_x ->
            {
                selectedSide = Constants.SIDE_X
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(Constants.EXTRA_SIDE,selectedSide)
                startActivity(intent)
            }
            R.id.img_dialog_circle ->
            {
                selectedSide = Constants.SIDE_CIRCLE
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra(Constants.EXTRA_SIDE,selectedSide)
                startActivity(intent)
            }
        }
    }


}