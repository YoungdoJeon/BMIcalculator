package BMIcal.com

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun loadData() {
            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val height = pref.getInt("KEY_HEIGHT", 0)
            val weight = pref.getInt("KEY_WEIGHT", 0)

            if(height !=0 && weight !=0) {
                heightEditText.setText(height.toString())
                weightEditText.setText(weight.toString())
            }
        }

        loadData()


        resultButton.setOnClickListener {
             fun saveData(height:Int, weight:Int) {
                val pref = PreferenceManager.getDefaultSharedPreferences(this)
                val editor = pref.edit()
                editor.putInt("KEY_HEIGHT", height)
                    .putInt("KEY_WEIGHT", weight)
                    .apply()
            }

            saveData(heightEditText.text.toString().toInt(),
                weightEditText.text.toString().toInt())

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("weight", weightEditText.text.toString())
            intent.putExtra("height", heightEditText.text.toString())
            startActivity(intent)

        }
    }
}
