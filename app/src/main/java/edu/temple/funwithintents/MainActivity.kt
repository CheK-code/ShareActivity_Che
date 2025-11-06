package edu.temple.funwithintents

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("UnsafeIntentLaunch")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // This view contains the text to share
        val editText = findViewById<EditText>(R.id.editTextText)
        val shareButton = findViewById< ImageButton>(R.id.shareImageButton)

        shareButton.setOnClickListener {
            val textToShare = editText.text.toString().trim()

            if (textToShare.isNotEmpty()) {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, textToShare)
                    type = "text/plain"
                }

                startActivity(Intent.createChooser(shareIntent, "Share Via"))
            } else {
                Toast.makeText(this, "Enter text to share", Toast.LENGTH_SHORT).show()
            }
        }
    }
}