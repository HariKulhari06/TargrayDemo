package com.hari.sample.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hari.sample.R
import com.hari.sample.databinding.FragmentUsersBinding
import com.hari.sample.utils.ext.logE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {

    private val mViewModel: UsersViewModel by viewModels()

    @Inject
    lateinit var usersAdapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentUsersBinding.bind(view)
        binding.recyclerView.adapter = usersAdapter
        lifecycleScope.launch {
            mViewModel.usersFlow.collect {users->
                usersAdapter.submitList(users)
            }
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            mViewModel.refreshUsers()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }
}