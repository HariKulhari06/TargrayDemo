package com.hari.sample.ui.employee

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hari.sample.R
import com.hari.sample.databinding.EmployeesFragmentBinding
import com.hari.sample.employee
import com.hari.sample.emptyEmployeeScreen
import com.hari.sample.model.Employee
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EmployeesFragment : Fragment(R.layout.employees_fragment) {
    private val viewModel: EmployeesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = EmployeesFragmentBinding.bind(view)

        binding.addEmployee.setOnClickListener {
            viewModel.addEmployee()
        }

        lifecycleScope.launch {
            viewModel.employees.collect { employees ->
                buildModels(binding, employees)
            }
        }
    }

    private fun buildModels(binding: EmployeesFragmentBinding, employees: List<Employee>) {
        binding.addEmployee.isVisible = employees.isNullOrEmpty().not()
        binding.recyclerView.withModels {
            if (employees.isNullOrEmpty()) {
                emptyEmployeeScreen {
                    id(R.id.epoxy_recycler_view_child_initial_size_id)
                    clickListener { _ ->
                        viewModel.addEmployee()
                    }
                }
            } else {

                employees.forEach { employee ->
                    employee {
                        id(employee.id)
                        employee(employee)
                        clickListener { view ->
                            when (view.id) {
                                R.id.card -> {

                                }
                                R.id.edit -> {

                                }
                            }
                        }
                    }
                }
            }
        }
    }

}