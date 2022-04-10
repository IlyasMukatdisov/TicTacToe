package com.gmail.mukatdisovilyas.tictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.gmail.mukatdisovilyas.tictactoe.Constants.Companion.CURRENTLY_UNKNOWN
import com.gmail.mukatdisovilyas.tictactoe.Constants.Companion.DRAW
import com.gmail.mukatdisovilyas.tictactoe.Constants.Companion.ENEMY_WIN
import com.gmail.mukatdisovilyas.tictactoe.Constants.Companion.USER_WIN
import kotlin.math.min

class GameActivity : AppCompatActivity(), View.OnClickListener
{
    private var userSide: Int = 0
    private var enemySide: Int = 0

    private lateinit var ll: LinearLayout

    private lateinit var image1: ImageView
    private lateinit var image2: ImageView
    private lateinit var image3: ImageView
    private lateinit var image4: ImageView
    private lateinit var image5: ImageView
    private lateinit var image6: ImageView
    private lateinit var image7: ImageView
    private lateinit var image8: ImageView
    private lateinit var image9: ImageView

    private val checkedImages = mutableListOf<ImageView>()
    private var uncheckedImages = mutableListOf<ImageView>()

    private val userMarked = mutableListOf<Int>()
    private val enemyMarked = mutableListOf<Int>()

    private lateinit var randomPosition: ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        initViews()
        uncheckedImages =
            mutableListOf(image1, image2, image3, image4, image5, image6, image7, image8, image9)
        setImageSizes()
        setOnClickListener()
        getSides()


    }

    private fun setImageSizes()
    {
        val minSide = min(Constants.SCREEN_HEIGHT, Constants.SCREEN_WIDTH)
        ll.layoutParams.width = minSide
        ll.layoutParams.height = minSide
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
        image1 = findViewById(R.id.image1)
        image2 = findViewById(R.id.image2)
        image3 = findViewById(R.id.image3)
        image4 = findViewById(R.id.image4)
        image5 = findViewById(R.id.image5)
        image6 = findViewById(R.id.image6)
        image7 = findViewById(R.id.image7)
        image8 = findViewById(R.id.image8)
        image9 = findViewById(R.id.image9)

        ll=findViewById(R.id.linearLayout)
    }

    private fun getSides()
    {
        if (intent.hasExtra(Constants.EXTRA_SIDE))
        {
            if (intent.getIntExtra(Constants.EXTRA_SIDE, Constants.SIDE_X) == Constants.SIDE_X)
            {
                userSide = R.drawable.ic_x
                enemySide = R.drawable.ic_0
            } else
            {
                userSide = R.drawable.ic_0
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
                if (image1 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image1)
                    makeAIStep()
                    userMarked.add(1)
                    endGameDialog()
                }
            }

            R.id.image2 ->
            {
                if (image2 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image2)
                    makeAIStep()
                    userMarked.add(2)
                    endGameDialog()
                }
            }
            R.id.image3 ->
            {
                if (image3 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image3)
                    makeAIStep()
                    userMarked.add(3)
                    endGameDialog()
                }
            }
            R.id.image4 ->
            {
                if (image4 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image4)
                    makeAIStep()
                    userMarked.add(4)
                    endGameDialog()
                }
            }
            R.id.image5 ->
            {
                if (image5 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image5)
                    makeAIStep()
                    userMarked.add(5)
                    endGameDialog()
                }
            }
            R.id.image6 ->
            {
                if (image6 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image6)
                    makeAIStep()
                    userMarked.add(6)
                    endGameDialog()
                }

            }
            R.id.image7 ->
            {
                if (image7 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image7)
                    makeAIStep()
                    userMarked.add(7)
                    endGameDialog()
                }
            }
            R.id.image8 ->
            {
                if (image8 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image8)
                    makeAIStep()
                    userMarked.add(8)
                    endGameDialog()
                }
            }
            R.id.image9 ->
            {
                if (image9 in uncheckedImages)
                {
                    v.background = AppCompatResources.getDrawable(this, userSide)
                    updateLists(image9)
                    makeAIStep()
                    userMarked.add(9)
                    endGameDialog()
                }
            }
        }
    }

    private fun endGameDialog()
    {
        val dialog = AlertDialog.Builder(this)
        when (isGameOver())
        {
            USER_WIN          ->
            {
                dialog.setTitle("Congratulations!").setMessage("You have won")
                    .setPositiveButton("Ok") { d, id ->
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        d.dismiss()
                    }.show()
            }
            ENEMY_WIN         ->
            {
                dialog.setTitle("Oops!").setMessage("You have lost")
                    .setPositiveButton("Ok") { d, id ->
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        d.dismiss()
                    }.show()
            }
            DRAW              ->
            {
                dialog.setTitle("Incredible!").setMessage("Draw").setPositiveButton("Ok") { d, id ->
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    d.dismiss()
                }.show()
            }
            CURRENTLY_UNKNOWN ->
            {
                return
            }
        }
    }

    private fun makeAIStep()
    {
        if (uncheckedImages.size > 1)
        {
            randomPosition = uncheckedImages.random()
            randomPosition.background = AppCompatResources.getDrawable(this, enemySide)
            updateLists(randomPosition)

            when (randomPosition)
            {
                image1 ->
                {
                    enemyMarked.add(1)
                }
                image2 ->
                {
                    enemyMarked.add(2)
                }
                image3 ->
                {
                    enemyMarked.add(3)
                }
                image4 ->
                {
                    enemyMarked.add(4)
                }
                image5 ->
                {
                    enemyMarked.add(5)
                }
                image6 ->
                {
                    enemyMarked.add(6)
                }
                image7 ->
                {
                    enemyMarked.add(7)
                }
                image8 ->
                {
                    enemyMarked.add(8)
                }
                image9 ->
                {
                    enemyMarked.add(9)
                }
            }

        }
    }

    private fun isGameOver(): Int
    {
        if (uncheckedImages.size > 1)
        {
            if ((userMarked.contains(1) && userMarked.contains(2) && userMarked.contains(3))
                || (userMarked.contains(1) && userMarked.contains(5) && userMarked.contains(9))
                || (userMarked.contains(1) && userMarked.contains(4) && userMarked.contains(7))
                || (userMarked.contains(3) && userMarked.contains(6) && userMarked.contains(9))
                || (userMarked.contains(7) && userMarked.contains(8) && userMarked.contains(9))
            ) return USER_WIN
            if ((enemyMarked.contains(1) && enemyMarked.contains(2) && enemyMarked.contains(3))
                || (enemyMarked.contains(1) && enemyMarked.contains(5) && enemyMarked.contains(9))
                || (enemyMarked.contains(1) && enemyMarked.contains(4) && enemyMarked.contains(7))
                || (enemyMarked.contains(3) && enemyMarked.contains(6) && enemyMarked.contains(9))
                || (enemyMarked.contains(7) && enemyMarked.contains(8) && enemyMarked.contains(9))
            ) return ENEMY_WIN
            return CURRENTLY_UNKNOWN
        } else return DRAW
    }

    private fun updateLists(image: ImageView)
    {
        checkedImages.add(image)
        uncheckedImages.remove(image)
    }

}