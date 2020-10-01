package com.ronney.mysubscribers.ui.subscriberlist


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ronney.mysubscribers.R
import com.ronney.mysubscribers.data.db.AppDatabase
import com.ronney.mysubscribers.data.db.dao.SubscriberDAO
import com.ronney.mysubscribers.data.db.entity.SubscriberEntity
import com.ronney.mysubscribers.repository.DatabaseDataSource
import com.ronney.mysubscribers.repository.SubscriberRepository
import com.ronney.mysubscribers.ui.subscriber.SubscriberViewModel
import kotlinx.android.synthetic.main.subscriber_list_fragment.*

class SubscriberListFragment : Fragment(R.layout.subscriber_list_fragment) {

    private val viewModel: SubscriberListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {

                val subscriberDAO: SubscriberDAO =
                    AppDatabase.getInstance(requireContext()).subscriberDAO
                val repository: SubscriberRepository = DatabaseDataSource(subscriberDAO)
                return SubscriberListViewModel(repository) as T
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModelEvents()
    }

    private fun observerViewModelEvents() {
        viewModel.allSubscribersEvent.observe(viewLifecycleOwner) { allSubscribers->

            val subscriberListAdapter = SubscriberListAdapter(allSubscribers)

            with(recycler_subscribers) {
                setHasFixedSize(true)
                adapter = subscriberListAdapter
            }
        }
    }
}