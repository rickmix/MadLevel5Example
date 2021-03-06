package com.example.madlevel4example

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5example.ReminderViewModel
import kotlinx.android.synthetic.main.fragment_add_reminder.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddReminderFragment : Fragment() {

    private val viewModel: ReminderViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnAddReminder.setOnClickListener {
            onAddReminder()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun onAddReminder() {
        val reminderText = etReminderName.text.toString()

        if(reminderText.isNotBlank()) {
            viewModel.insertReminder(Reminder(reminderText))

            findNavController().popBackStack()
        } else {
            Toast.makeText(
                activity,
                R.string.not_valid_reminder, Toast.LENGTH_SHORT
            ).show()
        }
    }
}