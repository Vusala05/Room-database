package com.example.roomnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomnew.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var contactDao: ContactDao
    private lateinit var database: ContactDatabase
    private lateinit var adapter: ContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = ContactDatabase.getDatabase(this)
        contactDao = database.contactDao()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadContacts()
    }

    private fun loadContacts() {
        CoroutineScope(Dispatchers.IO).launch {
            val users = contactDao.getAllContacts()



            val contacts = contactDao.getAllContacts()
            withContext(Dispatchers.Main) {
                adapter = ContactAdapter(contacts)
                binding.recyclerView.adapter = adapter
            }
        }
    }
}
