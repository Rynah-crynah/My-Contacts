package com.example.mycontacts

import android.content.Intent
import android.util.AndroidException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class ContactsRvAdapter (var contactList: List<Contact>):
RecyclerView.Adapter<ContactsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        var ContactsViewHolder = ContactsViewHolder(binding)
        return  ContactsViewHolder

    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvNumber.text = currentContact.phoneNumber
        holder.binding.tvEmail.text = currentContact.email
        holder.binding.tvAddress.text = currentContact.address
        Picasso.get()
            .load(currentContact.image)
            .placeholder(R.drawable.ic_baseline_person_24)
            .resize(300,300)
            .error(R.drawable.ic_baseline_error_outline_24)
            .resize(300,300)
            .centerCrop()
//            .networkPolicy(NetworkPolicy.OFFLINE)
            .into(holder.binding.ivContact)

        val context = holder.itemView.context
        holder.binding.ivContact.setOnClickListener {
            Toast.makeText(context,"You have clicked on ${currentContact.name}'s image", Toast.LENGTH_SHORT).show()
        }
        holder.binding.cvContact.setOnClickListener {
            val intent = Intent(context,ViewConatactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("EMAIL", currentContact.email)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
    return contactList.size
    }
}

class ContactsViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

    }