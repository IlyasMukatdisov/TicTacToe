package com.gmail.mukatdisovilyas.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources

class GameActivity : AppCompatActivity(), View.OnClickListener
{
    private var userSide: Int = 0
    private var enemySide: Int = 0

    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView
    private lateinit var image8: ImageView
    private lateinit var image9: ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initViews()
        setOnClickListener()
        getSides()



    }

    private fun setOnClickListener()
    {
        image1.setOnClickListener(this)
        image2.setOnClickListener(this)
        image3.setOnClickListener(this)
        image4.setOnClickListener(this)
        image5.setOnClickListener(this)
        image6.setOnClickListener(this)
        image7.setOnClickListener(this)
        image8.setOnClickListener(this)
        image9.setOnClickListener(this)
    }

    private fun initViews()
    {
        image1= findViewById(R.id.image1)
        image2= findViewById(R.id.image2)
        image3= findViewById(R.id.image3)
        image4= findViewById(R.id.image4)
        image5= findViewById(R.id.image5)
        image6= findViewById(R.id.image6)
        image7= findViewById(R.id.image7)
        image8= findViewById(R.id.image8)
        image9= findViewById(R.id.image9)
    }

    private fun getSides()
    {
        if (intent.hasExtra(Constants.EXTRA_SIDE))
        {
            if (intent.getIntExtra(Constants.EXTRA_SIDE, Constants.SIDE_X) == Constants.SIDE_X)
            {
                userSide = R.drawable.ic_x
                enemySide = R.drawable.ic_circle
            } else
            {
                userSide = R.drawable.ic_circle
                enemySide = R.drawable.ic_x
            }
        }
    }

    override fun onClick(v: View?)
    {
        when (v?.id)
        {
            R.id.image1 ->
            {
                if (!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this, userSide)
            }

            R.id.image2 ->
            {
                if (!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this, userSide)
            }
            R.id.image3 ->
            {
                if (!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this, userSide)
            }
            R.id.image4->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
            R.id.image5->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
            R.id.image6->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
            R.id.image7->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
            R.id.image8->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
            R.id.image9->{
                if(!checkForChecked(v))
                    v.background = AppCompatResources.getDrawable(this,userSide)
            }
        }
    }

    private fun checkForChecked(v: View): Boolean
    {
        return v.background == AppCompatResources.getDrawable(this, userSide) ||
                v.background == AppCompatResources.getDrawable(this, enemySide)
    }
}