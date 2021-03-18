package com.hari.sample.ui.employee.details

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.hari.sample.R
import com.hari.sample.databinding.EmployeeDetailsFragmentBinding
import com.hari.sample.model.Employee
import com.hari.sample.model.Gender
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmployeeDetailsFragment : Fragment(R.layout.employee_details_fragment) {

    private val employeeDetailsViewModel: EmployeeDetailsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = EmployeeDetailsFragmentBinding.bind(view)
        binding.employeeDetailsViewModel = employeeDetailsViewModel
        binding.lifecycleOwner = viewLifecycleOwner


        val items = mutableListOf<Int>()
        (20..70).forEach {
            items.add(it)
        }
        val adapter = ArrayAdapter(requireContext(), R.layout.item_age, items)
        binding.ageAutoComp.setAdapter(adapter)

        binding.btnSave.setOnClickListener {
            val name = binding.name.text.toString().trim()
            val gender =
                if (binding.radioGroup.checkedRadioButtonId == R.id.male) Gender.MALE.id else Gender.FEMALE.id
            val age = binding.ageAutoComp.text.toString().trim()
            val address = binding.address.text.toString().trim()
            val salary = binding.salary.text.toString().trim()

            val isValid = when {
                name.isEmpty() -> {
                    showMessage("Please enter name")
                    false
                }
                age.isEmpty() -> {
                    showMessage("Please select age.")
                    false
                }
                address.isEmpty() -> {
                    showMessage("Please enter address.")
                    false
                }
                salary.isEmpty() -> {
                    showMessage("Please enter salary")
                    false
                }
                else -> {
                    true
                }
            }

            if (isValid)
                employeeDetailsViewModel.saveEmployee(Employee(
                    name = name,
                    address = address,
                    salary = salary.toDouble(),
                    age = age.toInt(),
                    gender = gender
                )) {
                    showMessage("Saved Successfully")
                    findNavController().navigateUp()
                }
        }

        employeeDetailsViewModel.employee.observe(viewLifecycleOwner, Observer {
            if(it.id>0){
                binding.ageAutoComp.threshold = Integer.MAX_VALUE;
                binding.ageAutoComp.setText(it.age.toString());
                binding.ageAutoComp.threshold = 1;
            }
        })

    }

    private fun showMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}