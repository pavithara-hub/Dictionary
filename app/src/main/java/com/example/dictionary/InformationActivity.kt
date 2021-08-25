package com.example.dictionary

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_information.*
import okhttp3.*

class InformationActivity : AppCompatActivity() {
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        info_word.text=getIntent().getStringExtra("WORD")
        info_synonyms.text="Synonyms: " + getIntent().getStringExtra("SYNONYMS")
        info_example.text="Example: " + getIntent().getStringExtra("EXAMPLE")

    }
}