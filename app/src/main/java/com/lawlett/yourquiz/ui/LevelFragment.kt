package com.lawlett.yourquiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lawlett.yourquiz.R
import com.lawlett.yourquiz.adapter.LevelsAdapter
import com.lawlett.yourquiz.core.BaseFragment
import com.lawlett.yourquiz.databinding.FragmentLevelBinding
import com.lawlett.yourquiz.room.data.GameLevel
import com.lawlett.yourquiz.utils.LevelPreference

class LevelFragment : BaseFragment(R.layout.fragment_level), LevelsAdapter.Listener {

    private var _binding: FragmentLevelBinding? = null
    private val binding get() = _binding!!
    private var list: MutableList<GameLevel> = mutableListOf()
    private val adapter = LevelsAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addList()
    }

    private fun initAdapter() {
        binding.levelRecycler.adapter = adapter
    }

    private fun addList() {
        var isShown: Boolean = LevelPreference.getInstance(requireContext())!!.isShown
        if (!isShown) {
            for (i in 1..1) list.add(GameLevel(id = i))
            adapter.add(list)
            LevelPreference.getInstance(requireContext())!!.saveShown()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(level: Int?) {
        findNavController().navigate(
            LevelFragmentDirections.actionLevelFragmentToGameFragment(
                level= level!!
            )
        )
    }
}