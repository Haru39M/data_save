package app.wakayama.harusame.edittext

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStore:SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        saveButton.setOnClickListener{
            val stringText = editText.text.toString()//入力欄から文字を取得
            saveText.text = stringText//書き換え
            val editor = dataStore.edit()
            editor.putString("Input",stringText)//InputはKey
            editor.apply()
        }
        readButton.setOnClickListener{
            //Inputから読み出す
            val str = dataStore.getString("input","NoData")
            readText.text = str
        }

    }
}