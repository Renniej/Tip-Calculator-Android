package org.hyperskill.calculator.tip

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import org.hyperskill.calculator.tip.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.BigInteger
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


    private fun getTipAmount() : BigDecimal{ //assumes validNumber


        val percentage = BigDecimal(binding.seekBar.progress.toDouble() / 100.toDouble())
        val amount = BigDecimal(binding.editText.text?.toString())


        return (percentage * amount).setScale(2,RoundingMode.HALF_EVEN)
    }

    private fun  refreshTextViews() {
        val num = binding.editText.text?.toString()?.toBigDecimalOrNull() ?: BigDecimal.ZERO
        val validNumber =  (num > BigDecimal.ZERO)


        if (validNumber) {
            binding.billValueTv.text = "Bill Value: $${num.setScale(2, RoundingMode.HALF_EVEN)}"
            binding.tipPercentTv.text =   "Tip: ${binding.seekBar.progress}%"
            binding.tipAmountTv.text = "Tip Amount: $" +
                    "${String.format("%.2f", binding.editText.text.toString().toBigDecimal()
                            * 0.01.toBigDecimal()
                            * binding.seekBar.progress.toBigDecimal())}"//"Tip Amount: $${String.format("%.2f", getTipAmount())}"
        }
        else {
            binding.billValueTv.text = ""
            binding.tipPercentTv.text = ""
            binding.tipAmountTv.text = ""
        }


    }

}