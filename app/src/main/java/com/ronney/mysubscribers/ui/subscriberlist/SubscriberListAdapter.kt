package com.ronney.mysubscribers.ui.subscriberlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ronney.mysubscribers.R
import com.ronney.mysubscribers.data.db.entity.SubscriberEntity
import kotlinx.android.synthetic.main.subscriber_item.view.*

class SubscriberListAdapter(
    private val subscribers: List<SubscriberEntity>
) :
    RecyclerView.Adapter<SubscriberListAdapter.SubscriberListViewHolder>() {

    var onItemClick: ((entity: SubscriberEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.subscriber_item, parent, false)
        return SubscriberListViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubscriberListViewHolder, position: Int) {
        holder.bindView(subscribers[position])
    }

    override fun getItemCount() = subscribers.size

    inner class SubscriberListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textViewSubscriberName: TextView = itemView.text_subscriber_name
        private val textViewSubscriberEmail: TextView = itemView.text_subscriber_mail

        fun bindView(subscriber: SubscriberEntity) {
            textViewSubscriberName.text = subscriber.name
            textViewSubscriberEmail.text = subscriber.email

            itemView.setOnClickListener{
                onItemClick?.invoke(subscriber)
            }
        }
    }
}