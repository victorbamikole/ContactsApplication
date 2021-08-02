package com.example.week5assignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.contacts_view.view.*

class ContactsAdapter(var contacts: List<Contacts>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    private lateinit var contactListener: onItemClickListener

    //Create click listner for our adpater class
    interface onItemClickListener {
        fun onContactItem(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        contactListener = listener
    }
    inner class ContactsViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val profileImage: CircleImageView = itemView.findViewById(R.id.profImage)

        init {

            itemView.setOnClickListener {
                listener.onContactItem(adapterPosition)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.contacts_view, parent, false)
        return ContactsViewHolder(view, contactListener)
    }
    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.itemView.apply {
            val currentItem = contacts[position]
            holder.profileImage.setImageResource(currentItem.profileImage)
            contactsName.text = currentItem.name
        }
    }
    override fun getItemCount(): Int {
        return contacts.size
    }
}





