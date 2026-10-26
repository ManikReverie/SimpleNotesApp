package com.example.simplenotesapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etContent = findViewById<EditText>(R.id.etContent)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val llNotesList = findViewById<LinearLayout>(R.id.llNotesList)

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please enter title and content", Toast.LENGTH_SHORT).show()
            } else {
                val newNote = TextView(this)
                newNote.text = "Title: $title\n$content\n"
                newNote.textSize = 16f
                newNote.setPadding(0, 10, 0, 10)
                
                // Add a simple divider
                val divider = View(this)
                divider.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 2
                )
                divider.setBackgroundColor(android.graphics.Color.LTGRAY)

                llNotesList.addView(newNote)
                llNotesList.addView(divider)

                etTitle.text.clear()
                etContent.text.clear()
            }
        }
    }
}