package com.example.buildingandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast


class SecondActivity : AppCompatActivity() {
    lateinit var txtResult : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        txtResult = findViewById(R.id.txt_result)
        val btnClear = findViewById(R.id.btn_clear)

        var result = intent.getStringExtra("result")
        txtResult.text = result

        btnClear.setOnClickListener {
            val sharedPreference =  getSharedPreferences(
                "app_preference", Context.MODE_PRIVATE
            )

            var editor = sharedPreference.edit()
            editor.clear()
            editor.remove("name")
            editor.commit()

            Toast.makeText(
                applicationContext,
                "Sesi berhasil dihapus!",
                Toast.LENGTH_SHORT
            ).show()

            override fun onBackPressed() {
                val sharedPreference =  getSharedPreferences(
                    "app_preference", Context.MODE_PRIVATE
                )

                var name = sharedPreference.getString("name", "").toString()

                if (name.isEmpty()) {
                    super.onBackPressed()
                    return
                }

                Toast.makeText(
                    applicationContext,
                    "Kamu masih memiliki sesi, harap hapus data terlebih dahulu!",
                    Toast.LENGTH_SHORT
                ).show()
            }
    }   }
}
