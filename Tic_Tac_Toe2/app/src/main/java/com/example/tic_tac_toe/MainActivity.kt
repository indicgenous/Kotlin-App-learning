package com.example.tic_tac_toe


import android.content.DialogInterface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() , OnClickListener{

    var player=0
    var gameactive=true
    //    var ply = findViewById<TextView>(R.id.textView)
    lateinit var filledpos  :IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1=findViewById<Button>(R.id.btn1)
        var btn3=findViewById<Button>(R.id.btn2)
        var btn2=findViewById<Button>(R.id.btn3)
        var btn4=findViewById<Button>(R.id.btn4)
        var btn5=findViewById<Button>(R.id.btn5)
        var btn6=findViewById<Button>(R.id.btn6)
        var btn7=findViewById<Button>(R.id.btn7)
        var btn8=findViewById<Button>(R.id.btn8)
        var btn9=findViewById<Button>(R.id.btn9)

        filledpos = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)



        btn1.setOnClickListener (this)
        btn2.setOnClickListener (this)
        btn3.setOnClickListener (this)
        btn4.setOnClickListener (this)
        btn5.setOnClickListener (this)
        btn6.setOnClickListener (this)
        btn7.setOnClickListener (this)
        btn8.setOnClickListener (this)
        btn9.setOnClickListener (this)



    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(v: View?) {
        if(!gameactive){
            return
        }
        var ply = findViewById<TextView>(R.id.textView)
        var btnclicked = findViewById<Button>(v!!.id)
        var clickedtag=Integer.parseInt(btnclicked.tag.toString())

        if (filledpos[clickedtag]!=-1){
            return
        }
        filledpos[clickedtag]=player

        if(player==0){

            player=1
            btnclicked.setText("0")
            ply.setText("Player X")
            btnclicked.backgroundTintList = getColorStateList(R.color.yellow)

        }

        else if(player==1) {

            player = 0
            btnclicked.setText("X")
            ply.setText("Player 0")
            btnclicked.backgroundTintList = getColorStateList(R.color.green)

        }

        forwin()
    }

    //    winning condition
    @RequiresApi(Build.VERSION_CODES.M)
    private fun forwin() {
//        var ply = findViewById<TextView>(R.id.wint)
        var winpos = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(3, 6, 9),
            intArrayOf(3, 5, 7),
            intArrayOf(1, 5, 9),
        )
        for (i in 0 until winpos.size) {
            var val0 = winpos[i][0]
            var val1 = winpos[i][1]
            var val2 = winpos[i][2]

            if (filledpos[val0] == filledpos[val1] && filledpos[val1] == filledpos[val2]) {
                if (filledpos[val0] != -1) {
                    if (player == 0) {
                        gameactive = false
                        showmessage("Player X is winner")
                    } else {
                        gameactive = false
                        showmessage("Player 0 is winner")
                    }

                }
                return

            }

        }

//            draw condition
        var count = 0
        for (i in 1 until filledpos.size){
            if (filledpos[i] == -1) {
                count++
            }
        }
        if (count==0){
            showmessage("It's Draw")
            return
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showmessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe")
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { dialog, which ->restartgame()  })
            .show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun restartgame(){
        filledpos = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
        var ply = findViewById<TextView>(R.id.textView)
        gameactive = true
        ply.setText("Player 0")
        player=0

        var btn1=findViewById<Button>(R.id.btn1)
        var btn2=findViewById<Button>(R.id.btn2)
        var btn3=findViewById<Button>(R.id.btn3)
        var btn4=findViewById<Button>(R.id.btn4)
        var btn5=findViewById<Button>(R.id.btn5)
        var btn6=findViewById<Button>(R.id.btn6)
        var btn7=findViewById<Button>(R.id.btn7)
        var btn8=findViewById<Button>(R.id.btn8)
        var btn9=findViewById<Button>(R.id.btn9)

        btn1.setText("")
        btn2.setText("")
        btn3.setText("")
        btn4.setText("")
        btn5.setText("")
        btn6.setText("")
        btn7.setText("")
        btn8.setText("")
        btn9.setText("")

        btn1.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn2.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn3.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn4.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn5.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn6.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn7.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn8.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)
        btn9.backgroundTintList=getColorStateList(com.google.android.material.R.color.design_default_color_primary)


    }



}