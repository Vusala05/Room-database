package com.example.roomnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomnew.databinding.ActivityDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var contactDao: ContactDao
    private lateinit var database: ContactDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = ContactDatabase.getDatabase(this)
        contactDao = database.contactDao()

        binding.submit.setOnClickListener {
            addContact()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun addContact() {
        val name = binding.name.text.toString()
        val surname = binding.surname.text.toString()

        if (name.isNotEmpty() && surname.isNotEmpty()) {
            val contact = Contact(name, surname)

            CoroutineScope(Dispatchers.IO).launch {

                contactDao.addContact(contact)

            }
        }
    }
}
