package com.example.veriparkimkb.view.imkblist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.veriparkimkb.R
import com.example.veriparkimkb.data.model.imkb.ListRequest
import com.example.veriparkimkb.databinding.FragmentImkbListBinding
import com.example.veriparkimkb.util.AESFunction
import com.example.veriparkimkb.view.handshake.HandshakeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImkbListFragment : Fragment(), ListAdapter.OnItemListener {

    private lateinit var binding: FragmentImkbListBinding
    private lateinit var adapter: ListAdapter
    private lateinit var imkbListViewModel: ImkbListViewModel
    private val handshakeViewModel: HandshakeViewModel by activityViewModels()
    private lateinit var stockPeriod: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_imkb_list, container, false)
        imkbListViewModel = ViewModelProvider(this).get(ImkbListViewModel::class.java)
        stockPeriod = requireArguments().getString("period", "all")
        initRecyclerView()

        binding.listSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                if (query == "")
                    adapter.filter.filter(query)
                return false
            }

        })

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ImkbListFragment().apply {}
    }

    private fun initRecyclerView() {
        binding.listRecyclerview.layoutManager = LinearLayoutManager(context)
        adapter = ListAdapter(this)
        binding.listRecyclerview.adapter = adapter
        displayStocks(stockPeriod)
    }

    private fun displayStocks(stockPeriod: String) {
        binding.listProgressBar.visibility = View.VISIBLE
        handshakeViewModel.getHandshake().observe(viewLifecycleOwner, { handshake ->
            imkbListViewModel.getImkbList(
                handshake.authorization,
                ListRequest(AESFunction.encrypt(stockPeriod, handshake.aesKey, handshake.aesIV))
            ).observe(viewLifecycleOwner,
                { imkb ->
                    if (imkb.body() != null && !imkb.body()!!.stocks.isEmpty()) {
                        adapter.setList(
                            imkb.body()!!.stocks,
                            handshake.aesKey,
                            handshake.aesIV
                        )
                        adapter.notifyDataSetChanged()
                        binding.listProgressBar.visibility = View.GONE
                    } else {
                        binding.listProgressBar.visibility = View.GONE
                        Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
                    }
                })
        })
    }

    override suspend fun onItemClick(position: Int) {

        handshakeViewModel.getHandshake().observe(this, {
            CoroutineScope(Dispatchers.Main).launch {
                val bundle = bundleOf("detailID" to adapter.stockList[position].id.toString())
                requireView().findNavController()
                    .navigate(R.id.action_imkbListFragment_to_imkbDetailFragment, bundle)
            }
        })
    }
}