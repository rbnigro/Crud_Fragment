package com.ronney.mysubscribers.ui.subscriberlist

import androidx.lifecycle.ViewModel
import com.ronney.mysubscribers.repository.SubscriberRepository

class SubscriberListViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val allSubscribersEvent = repository.getAllSubscribers()

}