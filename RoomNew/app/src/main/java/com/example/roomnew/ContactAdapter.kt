package com.example.roomnew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomnew.databinding.ContactBinding

class ContactAdapter(private val contactList: List<Contact>) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    class ContactHolder(val binding: ContactBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val binding = ContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = contactList[position]

            holder.binding.name.text = contact.name
           holder.binding.surname.text = contact.surname
        }
    }

