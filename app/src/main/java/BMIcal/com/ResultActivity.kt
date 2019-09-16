package BMIcal.com

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //전달받은 키 몸무게값
        val height = intent.getStringExtra("height").toInt()
        val weight = intent.getStringExtra("weight").toInt()

        // BMI계산
        val bmi = weight / Math.pow(height / 100.0, 2.0)

        when {
            bmi >= 35 -> resultTextView.text = "고도비만"
            bmi >= 30 -> resultTextView.text = "2단계비만"
            bmi >= 25 -> resultTextView.text = "1단계비만"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }

        when {
            bmi >= 25 -> imageView.setImageResource(
                R.drawable.ic_sentiment_dissatisfied_black_24dp
            )
            bmi >= 18.5 -> imageView.setImageResource(
                R.drawable.ic_sentiment_satisfied_black_24dp
            )
            else -> imageView.setImageResource(
                R.drawable.ic_sentiment_neutral_black_24dp
            )
        }

        Toast.makeText(this, "$bmi", Toast.LENGTH_LONG).show()
    }
}
