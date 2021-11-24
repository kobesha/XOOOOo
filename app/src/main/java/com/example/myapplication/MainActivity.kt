package com.example.myapplication
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import org.w3c.dom.Text
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var pirveli: Button
    private lateinit var meore: Button
    private lateinit var mesame: Button
    private lateinit var meotxe: Button
    private lateinit var mexute: Button
    private lateinit var meeqvse: Button
    private lateinit var meshvide: Button
    private lateinit var merve: Button
    private lateinit var mecxre: Button
    private lateinit var meate: Button
    var buttonNumber = 0
    private var winnerPlayer = 0
    private var XPoints = 0
    private var OPoints = 0
    private lateinit var X: TextView
    private lateinit var O: TextView
    private var activePlayer = 1
    private var firstPlayer = arrayListOf<Int>()
    private var secondPlayer = arrayListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        X = findViewById(R.id.X)
        O = findViewById(R.id.O)
        pirveli = findViewById(R.id.pirveli)
        pirveli.setOnClickListener(this)
        meore = findViewById(R.id.meore)
        meore.setOnClickListener(this)
        mesame = findViewById(R.id.mesame)
        mesame.setOnClickListener(this)
        meotxe = findViewById(R.id.meotxe)
        meotxe.setOnClickListener(this)
        mexute = findViewById(R.id.mexute)
        mexute.setOnClickListener(this)
        meeqvse = findViewById(R.id.meeqvse)
        meeqvse.setOnClickListener(this)
        meshvide = findViewById(R.id.meshvide)
        meshvide.setOnClickListener(this)
        merve = findViewById(R.id.merve)
        merve.setOnClickListener(this)
        mecxre = findViewById(R.id.mecxre)
        mecxre.setOnClickListener(this)
        meate = findViewById(R.id.meate)
        meate.setOnClickListener {
            pirveli.text = ""
            meore.text = ""
            mesame.text = ""
            meotxe.text = ""
            mexute.text = ""
            meeqvse.text = ""
            meshvide.text = ""
            merve.text = ""
            mecxre.text = ""
            firstPlayer.clear()
            secondPlayer.clear()
            pirveli.setBackgroundColor(Color.parseColor("#000000"))
            meore.setBackgroundColor(Color.parseColor("#000000"))
            mesame.setBackgroundColor(Color.parseColor("#000000"))
            meotxe.setBackgroundColor(Color.parseColor("#000000"))
            mexute.setBackgroundColor(Color.parseColor("#000000"))
            meeqvse.setBackgroundColor(Color.parseColor("#000000"))
            meshvide.setBackgroundColor(Color.parseColor("#000000"))
            merve.setBackgroundColor(Color.parseColor("#000000"))
            mecxre.setBackgroundColor(Color.parseColor("#000000"))
            pirveli.isEnabled = true
            meore.isEnabled = true
            mesame.isEnabled = true
            meotxe.isEnabled = true
            mexute.isEnabled = true
            meeqvse.isEnabled = true
            merve.isEnabled = true
            mecxre.isEnabled = true
            meate.isEnabled = true
            activePlayer = 1
            winnerPlayer = 0
        }
    }
    override fun onClick(clickedView: View?) {
        if (clickedView is Button) {

            when (clickedView.id) {
                R.id.pirveli -> buttonNumber = 1
                R.id.meore -> buttonNumber = 2
                R.id.mesame -> buttonNumber = 3
                R.id.meotxe -> buttonNumber = 4
                R.id.mexute -> buttonNumber = 5
                R.id.meeqvse -> buttonNumber = 6
                R.id.meshvide -> buttonNumber = 7
                R.id.merve -> buttonNumber = 8
                R.id.mecxre -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playGame(clickedView, buttonNumber)
            }
        }
    }
    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedView.text = "x"
            clickedView.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedView.text = "o"
            clickedView.setBackgroundColor(Color.BLUE)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }
    private fun check() {
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (firstPlayer.contains(8) && firstPlayer.contains(5) && firstPlayer.contains(2)) {
            winnerPlayer = 1
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(8) && secondPlayer.contains(5) && secondPlayer.contains(2)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (winnerPlayer == 1 || winnerPlayer == 2) {
            pirveli.isEnabled = false
            meore.isEnabled = false
            mesame.isEnabled = false
            meotxe.isEnabled = false
            mexute.isEnabled = false
            meeqvse.isEnabled = false
            meshvide.isEnabled = false
            merve.isEnabled = false
            mecxre.isEnabled = false
        }

        if (winnerPlayer == 1) {
            XPoints += 1
            val point1 = XPoints.toString()
            X.text = "Player X: $point1"
        }
        if (winnerPlayer == 2) {
            OPoints += 1
            val point2 = OPoints.toString()
            O.text = "Player O: $point2"
        }
    }


}