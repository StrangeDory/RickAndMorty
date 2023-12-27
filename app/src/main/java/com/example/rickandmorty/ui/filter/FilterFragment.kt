package com.example.rickandmorty.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_filter.chipgroup_status
import kotlinx.android.synthetic.main.fragment_filter.radiogroup_gender

@AndroidEntryPoint
class FilterFragment: BottomSheetDialogFragment() {
    private val viewModel: FilterViewModel by viewModels()
    private lateinit var binding: FragmentFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFilterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.filterValue.observe(viewLifecycleOwner) {
            chipgroup_status.setChipChecked(it[0])
            radiogroup_gender.setButtonChecked(it[1])
        }

        binding.btnMakeFilter.setOnClickListener {
            if(binding.chipgroupStatus.getTextChipChecked().isNotEmpty() && binding.radiogroupGender.getTextButtonChecked().isNotEmpty()) {
                viewModel.getByStatusAndGender(binding.chipgroupStatus.getTextChipChecked(), binding.radiogroupGender.getTextButtonChecked())
            }else{
                if(binding.chipgroupStatus.getTextChipChecked().isNotEmpty()){
                    viewModel.getByStatus(binding.chipgroupStatus.getTextChipChecked())
                }else{
                    viewModel.getByGender(binding.radiogroupGender.getTextButtonChecked())
                }
            }

            viewModel.filterValue.value = arrayOf(binding.chipgroupStatus.checkedChipId, binding.radiogroupGender.checkedRadioButtonId)

            findNavController().popBackStack(R.id.charactersFragment, false)
        }
    }

    fun ChipGroup.getTextChipChecked(): String{
        val selectedId: Int = this.checkedChipId
        return if(selectedId > -1) findViewById<Chip>(selectedId).text.toString() else ""
    }

    fun ChipGroup.setChipChecked(selectedId: Int){
        if(selectedId > 0) this.findViewById<Chip>(selectedId).isChecked = true
    }

    fun RadioGroup.getTextButtonChecked(): String {
        val selectedId: Int = this.checkedRadioButtonId
        return if(selectedId > -1) findViewById<RadioButton>(selectedId).text.toString() else ""
    }

    fun RadioGroup.setButtonChecked(selectedId: Int) {
        if(selectedId > 0) findViewById<RadioButton>(selectedId).isChecked = true
    }
}