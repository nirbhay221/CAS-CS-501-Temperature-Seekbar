package com.example.temperaturescale

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var celsiusTextView:TextView;
    private lateinit var fahrenheitTextView:TextView
    private lateinit var messagedisplay:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        celsiusTextView = findViewById(R.id.celsiusTextView)

        fahrenheitTextView = findViewById(R.id.FahrenheitTextView)
        messagedisplay = this.findViewById(R.id.messagedisplay)

        var celsiusSeekBar = findViewById<SeekBar>(R.id.celsiusseekBar)


        var fahrenheitSeekBar = findViewById<SeekBar>(R.id.fahrenheitseekbar)
        celsiusSeekBar.max = 100
        fahrenheitSeekBar.max = 212
        var celsiusVal = 0.0;
        var fahrenheitVal = 32.0;
        celsiusSeekBar.progress = celsiusVal.toInt()
        fahrenheitSeekBar.progress = fahrenheitVal.toInt()

        celsiusSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    celsiusVal = progress.toDouble()
                    fahrenheitVal = ((celsiusVal * 9) / 5) + 32
                    updateTextViews(celsiusVal, fahrenheitVal)
                    fahrenheitSeekBar.progress = fahrenheitVal.toInt()
                    if(celsiusVal < 20){
                        messagedisplay.text = "it should be warmer"
                    }else{
                        messagedisplay.text = ""
                    }
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {


            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        fahrenheitSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    if(progress<32){
                        fahrenheitSeekBar.progress = 32
                    }else{

                        fahrenheitVal = progress.toDouble()
                        celsiusVal =((fahrenheitVal-32)*5)/9
                        updateTextViews(celsiusVal,fahrenheitVal)
                        celsiusSeekBar.progress = celsiusVal.toInt()
                    }
                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {


            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        updateTextViews(celsiusVal,fahrenheitVal)


    }

    private fun updateTextViews(celsiusVal: Double, fahrenheitVal: Double) {
        celsiusTextView.text = "${celsiusVal}"
        fahrenheitTextView.text="${fahrenheitVal}"
    }

}