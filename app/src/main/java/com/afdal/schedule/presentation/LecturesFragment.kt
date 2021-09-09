package com.afdal.schedule.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.afdal.schedule.MainActivity.Companion.TAG
import com.afdal.schedule.R
import com.afdal.schedule.databinding.FragmentLecturesBinding
import com.afdal.schedule.frameWork.ScheduleViewModelFactory
import com.airbnb.epoxy.EpoxyRecyclerView


class LecturesFragment : Fragment() {
    private lateinit var binding: FragmentLecturesBinding
    private val lecturesControllerEpoxy by lazy {
        LecturesControllerEpoxy()
    }
    private lateinit var btnDownload: Button
    private lateinit var recyclerView: EpoxyRecyclerView
    private val viewModel: LecturesViewModel by viewModels { ScheduleViewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lectures, container, false)

        recyclerView = binding.epoxyRecyclerView
        recyclerView.adapter = lecturesControllerEpoxy.adapter
        //    viewModel = ViewModelProviders.of(this, ScheduleViewModelFactory).get(LecturesViewModel::class.java)
        viewModel.personListLiveData.observe(viewLifecycleOwner, {
            if (it == null) {
                Toast.makeText(requireContext(), "some thing wrong happened", Toast.LENGTH_SHORT)
                    .show()
            } else {
                lecturesControllerEpoxy.setData(it)
           //     val jsonString: String = it.toString()
              //  Toast.makeText(requireContext(), jsonString, Toast.LENGTH_SHORT).show()
              //  Log.d(TAG, "DONE : : : : $jsonString")
            }
        })
        viewModel.loadLectures()
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}