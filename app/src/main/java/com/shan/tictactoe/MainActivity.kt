package com.shan.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    var player1count: Int = 0
    var player2count: Int = 0


    fun btnclick(view: View) {                               //To set function for the table
        val buttonSelected = view as Button
        var cell = 0
        when (buttonSelected.id) {
            R.id.button1 -> cell = 1
            R.id.button2 -> cell = 2
            R.id.button3 -> cell = 3
            R.id.button4 -> cell = 4
            R.id.button5 -> cell = 5
            R.id.button6 -> cell = 6
            R.id.button7 -> cell = 7
            R.id.button8 -> cell = 8
            R.id.button9 -> cell = 9
        }
        playgame(cell, buttonSelected)
    }

    var activeplayer = 1
    val player1 = ArrayList<Int>()
    val player2 = ArrayList<Int>()

    fun playgame(cell: Int, button: Button) {                      //Multiplayer

        if (activeplayer == 1) {
            button.text = "X"
            player1.add(cell)
            activeplayer = 2

        } else {
            button.text = "O"
            player2.add(cell)
            activeplayer = 1
        }
        button.isEnabled = false
        checkwinner()
    }


    fun checkwinner() {                                           //To check who the winner is
        var winner = 0

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        } else if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        } else if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        } else if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        } else if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        } else if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        } else if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        } else if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        } else {
            winner = 0
        }

        for (i in 0..9) {                                     //btn for the entire table
            val btn: Button = when (i) {
                1 -> button1
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> button1
            }
            if (winner == 1 || winner == 2) {
                btn.isEnabled = false
            }
        }
        val p1: Button = findViewById<Button>(R.id.player1)
        val p2: Button = findViewById<Button>(R.id.player2)
        val newGame: Button = findViewById<Button>(R.id.newGame)
        val playAgain: Button = findViewById(R.id.playAgain)
        if (winner == 1) {
            Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show()
            player1count += 1
            p1.text = "Player1-> $player1count"

        } else if (winner == 2) {
            Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show()
            player2count += 1
            p2.text = "Player2-> $player2count"

        }

        newGame.setOnClickListener {                         //Restart
            // playAgain() box change aaganum

            player1count = 0
            player2count = 0
            p1.text = "Player1-> 0"
            p2.text = "player2-> 0"
           // playAgain()
            activeplayer = 1
            player1.clear()
            player2.clear()
            for (i in 0..9) {
                val btn: Button = when (i) {
                    1 -> button1
                    2 -> button2
                    3 -> button3
                    4 -> button4
                    5 -> button5
                    6 -> button6
                    7 -> button7
                    8 -> button8
                    9 -> button9
                    else -> button1
                }
                btn.isEnabled = true
                btn.text = ""
            }
        }
        restart()
    }

    fun restart() {
        playAgain.setOnClickListener {
          //  fun playAgain() {                          //New game
                activeplayer = 1
                player1.clear()
                player2.clear()
                for (i in 0..9) {
                    val btn: Button = when (i) {
                        1 -> button1
                        2 -> button2
                        3 -> button3
                        4 -> button4
                        5 -> button5
                        6 -> button6
                        7 -> button7
                        8 -> button8
                        9 -> button9
                        else -> button1
                    }
                    btn.isEnabled = true
                    btn.text = ""
                }
            }
        }
    }
//}

      /*  fun playAgain(view: View) {                          //New game
            activeplayer = 1
            player1.clear()
            player2.clear()
            for (i in 0..9) {
                val btn: Button = when (i) {
                    1 -> button1
                    2 -> button2
                    3 -> button3
                    4 -> button4
                    5 -> button5
                    6 -> button6
                    7 -> button7
                    8 -> button8
                    9 -> button9
                    else -> button1
                }
                btn.isEnabled = true
                btn.text = ""
            }
        }
        */
