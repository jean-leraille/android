package com.example.episen.ui.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.episen.ViewModelFactory
import com.example.episen.data.models.Commune
import com.example.episen.databinding.FragmentHomeBinding
import com.example.episen.ui.adapter.SearchResultAdapter
import org.koin.android.ext.android.inject

class HomeFragment : Fragment(), SearchResultAdapter.ItemResultListener {

    private val viewModelFactory: ViewModelFactory by inject()
    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel: HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        homeViewModel = ViewModelProvider(requireActivity(), viewModelFactory)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.stateLiveData.observe(viewLifecycleOwner,
            Observer {
                handleState(it)
            }
        )
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int,
                before: Int, count: Int) {
                homeViewModel.getCommunes(s.toString(), "nom, code")
            }
        })
        binding.searchResult.adapter = SearchResultAdapter(this)
        binding.searchResult.layoutManager = LinearLayoutManager(context)

    }

    private fun handleState(state: HomeViewModel.States) {
        when (state) {
            is HomeViewModel.States.NoConnection -> {
                //progress.visibility= View.GONE
            }
            is HomeViewModel.States.OnGetCommunes -> {
                val communes = state.response
                if(!communes.isNullOrEmpty()) {
                    val resultAdapter = binding.searchResult.adapter as SearchResultAdapter
                    resultAdapter.itemList = communes
                    resultAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemSelected(item: Commune) {
        Toast.makeText(requireContext(), item.nom, Toast.LENGTH_SHORT).show()
    }
}