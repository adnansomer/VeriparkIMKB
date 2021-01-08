package com.example.veriparkimkb.view.handshake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.veriparkimkb.R
import com.example.veriparkimkb.databinding.FragmentHandshakeEnterBinding

class HandshakeFragment : Fragment() {

    private lateinit var binding: FragmentHandshakeEnterBinding
    private lateinit var viewModel: HandshakeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_handshake_enter, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(requireActivity()).get(HandshakeViewModel::class.java)
        binding.goToListButton.setOnClickListener {
            val action = HandshakeFragmentDirections.actionHandshakeFragmentToİmkbListFragment("all")
            findNavController().navigate(action)
        }
    }
}