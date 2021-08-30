package com.afdal.schedule.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.R
import com.afdal.schedule.frameWork.ScheduleViewModelFactory


class LecturesFragment : Fragment() {
    private lateinit var viewModel: LecturesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this, ScheduleViewModelFactory).get(LecturesViewModel::class.java)
        viewModel.fileLiveData.observe(viewLifecycleOwner,  { it ->
            if (it == null){
                Toast.makeText(requireContext(), "wrong url", Toast.LENGTH_SHORT).show()
            }else{
                val jsonString : String =it.bufferedReader().use { it.readText() }
                Toast.makeText(requireContext(), jsonString, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "DONE : : : : $jsonString")
            }
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lectures, container, false)
    }


}