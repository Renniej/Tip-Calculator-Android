package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    private lateinit var binding :  ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.doAfterTextChanged {
            refreshTextViews()
        }

        binding.seekBar.setOnSeekBarChangeListener (object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar, progress: Int, fromUser: Boolean) {
                refreshTextViews()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }


        })
    }

    private fun  refreshTextViews() {
        val num = binding.editText.text?.toString()?.toBigDecimalOrNull() ?: BigDecimal.ZERO
        val validNumber =  (num > BigDecimal.ZERO)

        if (validNumber) {
            binding.billValueTv.text = "Bill Value: $${num.setScale(2, RoundingMode.HALF_EVEN)}"
            binding.tipPercentTv.text =   "Tip: ${binding.seekBar.progress}%"
        }
        else {
            binding.billValueTv.text = ""
            binding.tipPercentTv.text = ""
        }


    }

}