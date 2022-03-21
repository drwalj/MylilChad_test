package com.example.mytestempty

import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.Socket


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lvlButton = findViewById<Button>(R.id.button)
        val pointButton = findViewById<Button>(R.id.pointsAdden)
        val changerbtn = findViewById<Button>(R.id.changerbtn)

        val daTextView = findViewById<TextView>(R.id.textView)
        val ptAnzeige = findViewById<TextView>(R.id.pointAnzeige)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val dalvlView = findViewById<TextView>(R.id.lvlAnzeige)
        val infoSender = findViewById<Button>(R.id.infoSender)

        var level = 1
        var points = 0
        var progress = 0
/*
        fun sendstring(info:String) {
            val s1 = DatagramSocket(6789, InetAddress.getLocalHost() )
            val client = Socket(InetAddress.getLocalHost(), 6789) #idk whats wrong with
            var d1 = DatagramPacket()
            s1.send()
            client.outputStream.write(info.length)
            client.outputStream.write(info.toByteArray())
            client.close()
        }

        fun postItem(item: ClipData.Item) {
            val token = sendstring("t")
            val post = submitPost(token, item)
            processPost(post)
        }




        infoSender.setOnClickListener{
            send("fortnite")
        }*/

        pointButton.setOnClickListener{
            points++
            ptAnzeige.text= "Points: $points"
        }


        changerbtn.setOnClickListener{
            daTextView.text = "Fortnite"

        }

        lvlButton.setOnClickListener{
            if (points >=10){
                if (progress + 10 >= 30){
                    level ++
                    dalvlView.text = "lvl: $level"
                    points -=10
                    ptAnzeige.text= "Points: $points"
                    Toast.makeText(this@MainActivity, "Leveled Up!", Toast.LENGTH_SHORT).show()
                    progress = 0
                    progressBar.progress = progress

                }
                else {
                    points -=10
                    ptAnzeige.text= "Points: $points"
                    progress +=10
                    progressBar.progress = (progress*3)
                }
            }

        }

    }
}