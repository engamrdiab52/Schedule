package com.afdal.schedule.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.R
import com.afdal.schedule.frameWork.ScheduleViewModelFactory


class LecturesFragment : Fragment() {
    private lateinit var btnDownload  :Button
    private  val viewModel: LecturesViewModel by viewModels {ScheduleViewModelFactory}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

    //    viewModel = ViewModelProviders.of(this, ScheduleViewModelFactory).get(LecturesViewModel::class.java)
        viewModel.personListLiveData.observe(viewLifecycleOwner,  {
            if (it == null){
                Toast.makeText(requireContext(), "some thing wrong happened", Toast.LENGTH_SHORT).show()
            }else{
                val jsonString : String =it.toString()
                Toast.makeText(requireContext(), jsonString, Toast.LENGTH_SHORT).show()
                Log.d(TAG, "DONE : : : : $jsonString")
            }
        })
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lectures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnDownload = view.findViewById(R.id.btn_download)
        btnDownload.setOnClickListener {
            viewModel.loadLectures()
        }
    }


}