package com.example.imada2p1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class imada2p2 : AppCompatActivity() {
    //The IIE. 2024.
    private lateinit var i: CountDownTimer
    private lateinit var j: CountDownTimer
    private lateinit var imgDisp: ImageView
    private lateinit var dispClean: TextView
    private lateinit var dispHunger: TextView
    private lateinit var disphHappy: TextView
    private lateinit var pbrClean: ProgressBar
    private lateinit var pbrHunger: ProgressBar
    private lateinit var pbrHappy: ProgressBar

    private var clean = 100
    private var feed = 100
    private var play = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imada2p2)

        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnClean = findViewById<Button>(R.id.btnWash)
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        dispClean = findViewById<TextView>(R.id.dispClean)
        dispHunger = findViewById<TextView>(R.id.dispHunger)
        disphHappy = findViewById<TextView>(R.id.dispHappy)
        pbrClean = findViewById<ProgressBar>(R.id.pbrClean)
        pbrHunger = findViewById<ProgressBar>(R.id.pbrHunger)
        pbrHappy = findViewById<ProgressBar>(R.id.pbrHppy)
        imgDisp = findViewById<ImageView>(R.id.imgDisp)

        i = object : CountDownTimer(Long.MAX_VALUE, 2000) {
            override fun onTick(millisUntilFinished: Long) {
                //The IIE. 2024.
                if (clean > 0) {
                    clean -= 1
                    dispClean.text = "$clean/100"
                    pbrClean.progress = clean   //Chugh, A. 222
                }
                if (feed > 0) {
                    feed -= 1
                    dispHunger.text = "$feed/100"
                    pbrHunger.progress = feed   //Chugh, A. 222
                }
                if (play > 0) {
                    play -= 1
                    disphHappy.text = "$play/100"
                    pbrHappy.progress = play    //Chugh, A. 222
                }

            }

            override fun onFinish() {
                i.cancel()
            }
        }
//Ved. 2020.
        j = object : CountDownTimer(Long.MAX_VALUE, 5000) {
            override fun onTick(millisUntilFinished: Long) {
                //The IIE. 2024.
                if (clean <= 0 || feed <= 0 || play <= 0) {
                    imgDisp.setImageResource(R.drawable.sad)    //Figure 5: Johansen, F. [s.a].
                                                                //Disappointed Snoopy.
                    Toast.makeText(this@imada2p2, "The dog is sad!\n" +
                            "Try feeding, playing or cleaning it", Toast.LENGTH_LONG).show()
                }
                else {
                    imgDisp.setImageResource(R.drawable.wait)   //Figure 4: BuzzFeed. [s.a]. Disney.
                }
            }

            override fun onFinish() {
                j.cancel()
            }
        }
//Ved. 2020.
        i.start()
        j.start()

        btnClean.setOnClickListener {   //The IIE. 2024.
            imgDisp.setImageResource(R.drawable.claen)  //Figure 6: Snoopy. [s.a]. Image result for
                                                        //snoopy dog.
            feed -= 10
            play -= 10

            if (clean < 100)
                clean += 50

            if (clean > 100)
                clean = 100

            dispClean.text = "$clean/100"
            pbrClean.progress = clean   //Chugh, A. 222
        }

        btnFeed.setOnClickListener {    //The IIE. 2024.

            imgDisp.setImageResource(R.drawable.eat)    //Figure 3: Molina, M. [s.a]. Disney.

            clean -= 10
            play -= 10

            if (feed < 100)
                feed += 50

            if (feed > 100)
                feed = 100

            dispHunger.text = "$feed/100"
            pbrHunger.progress = feed   //Chugh, A. 222
        }

        btnPlay.setOnClickListener {    //The IIE. 2024.

            imgDisp.setImageResource(R.drawable.play)   //Figure 2: Mandeville, C. [s.a]. Snoopy
                                                        //playing sax.

            clean -= 10
            feed -= 10

            if (play < 100)
                play += 50

            if (play > 100)
                play = 100

            disphHappy.text = "$play/100"
            pbrHappy.progress = play    //Chugh, A. 222
        }

        btnExit.setOnClickListener {    //The IIE. 2024.
            finish()
        }
    }
}

/*Refrence List

Chugh, A. 2022. Android ProgressBar using Kotlin. [Website] Available at:
https://www.digitalocean.com/community/tutorials/android-progressbar-using-kotlin[Accessed 24 April
2024].

BuzzFeed. [s.a]. Disney. [Online]. Available at:
https://www.pinterest.com/pin/67342956911785039/ [Accessed 23 April 2024].

GabrielleHavenDoorHangersSigns. 2020. Welcome Friends Snoopy Woodstock Door Hanger. [Online].
Available at: https://www.pinterest.com/pin/28569778876057082/ [Accessed 23 April 2024].

Johansen, F. [s.a]. Disappointed Snoopy. [Online]. Available at:
https://dk.pinterest.com/pin/341569952971098111/ [Accessed 23 April 2024].

Mandeville, C. [s.a]. Snoopy playing sax. [Online]. Available at:
https://www.pinterest.com/pin/290974825899447609/ [Accessed 23 April 2024].

Molina, M. [s.a]. Disney. [Online]. Available at:
https://www.pinterest.com/pin/797770521508688973/ [Accessed 23 April 2024].

Snoopy. [s.a]. Image result for snoopy dog. [Online]. Available at:
https://dk.pinterest.com/pin/341569952971098111/ [Accessed 23 April 2024].

The IIE. 2024. Introduction To Mobile Application Development[IMAD5112 Module Manual]. The
Independent Institute of Education: Unpublished.

Ved. 2020. Global variable for object CountDownTimer.[Website] Available at:
https://stackoverflow.com/questions/61007015/global-variable-for-object-countdowntimer [Accessed 24
April 2024].

Figure list
Figure 1: GabrielleHavenDoorHangersSigns. 2020. Welcome Friends Snoopy Woodstock Door Hanger.
Figure 2: Mandeville, C. [s.a]. Snoopy playing sax.
Figure 3: Molina, M. [s.a]. Disney.
Figure 4: BuzzFeed. [s.a]. Disney.
Figure 5: Johansen, F. [s.a]. Disappointed Snoopy.
Figure 6: Snoopy. [s.a]. Image result for snoopy dog.
*/