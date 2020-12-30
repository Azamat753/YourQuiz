package com.lawlett.yourquiz.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.lawlett.yourquiz.R
import com.lawlett.yourquiz.core.BaseFragment
import com.lawlett.yourquiz.databinding.FragmentGameBinding
import com.lawlett.yourquiz.extension.toastShow
import com.lawlett.yourquiz.viewmodels.GameViewModel
import org.koin.android.ext.android.inject


class GameFragment : BaseFragment(R.layout.fragment_game) {
    private val args: GameFragmentArgs by navArgs()
    private val viewModel by inject<GameViewModel>()
    lateinit var question: String
    lateinit var description: String
    lateinit var levelNumber: String
    lateinit var firstAnswer: String
    lateinit var secondAnswer: String
    lateinit var thirdAnswer: String
    lateinit var fourAnswer: String
    lateinit var answerQuestion: String
    lateinit var result: String

    var rightAnswer: Int = 0
    var wrongAnswer: Int = 0
    var currentLevel: Int = 1
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentLevel = 1
        viewModel.getLevel(currentLevel).observe(viewLifecycleOwner, { level ->
            val model = level[0]
            levelNumber = model.id.toString()
            description = model.description.toString()
            firstAnswer = model.firstOp.toString()
            secondAnswer = model.secondOp.toString()
            thirdAnswer = model.thirdOp.toString()
            fourAnswer = model.fourOp.toString()
            answerQuestion = model.answer.toString()
            question = model.question.toString()

            setData()
            firstButton()
            secondButton()
            thirdButton()
            fourButton()


        }
        )
    }

    private fun firstButton() {
        binding.firstBtn.setOnClickListener {
            if (firstAnswer == answerQuestion) {
                result = "Верно"
                rightAnswer++
                requireContext().toastShow("Верно")
                showDialog()
            } else {
                result = "Неа"
                showDialog()
                wrongAnswer++
                requireContext().toastShow("Неа")
            }
        }
    }

    private fun secondButton() {
        binding.secondBtn.setOnClickListener {
            if (secondAnswer == answerQuestion) {
                result = "Верно"
                rightAnswer++
                requireContext().toastShow("Верно")
                showDialog()
            } else {
                result = "Неа"
                showDialog()
                requireContext().toastShow("Неа")
            }
        }
    }

    private fun thirdButton() {
        binding.thirdBtn.setOnClickListener {
            if (thirdAnswer == answerQuestion) {
                result = "Верно"
                rightAnswer++
                requireContext().toastShow("Верно")
                showDialog()
            } else {
                result = "Неа"
                showDialog()
                wrongAnswer++
                requireContext().toastShow("Неа")
            }
        }
    }

    private fun fourButton() {
        binding.fourBtn.setOnClickListener {
            if (fourAnswer == answerQuestion) {
                result = "Верно"
                rightAnswer++
                requireContext().toastShow("Верно")
                showDialog()

            } else {
                result = "Неа"
                showDialog()
                wrongAnswer++
                requireContext().toastShow("Неа")
            }
        }
    }

    private fun setData() {
        binding.questionText.text = question
        binding.levelNumber.text = levelNumber
        binding.firstBtn.text = firstAnswer
        binding.secondBtn.text = secondAnswer
        binding.thirdBtn.text = thirdAnswer
        binding.fourBtn.text = fourAnswer
    }

    private fun showResultDialog() {
        val mDialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.result_dialog, null)
        val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogView)
            .setTitle("Результаты")
        val mAlertDialog = mBuilder.show()
        mDialogView.findViewById<TextView>(R.id.right_an_tv).text = "Верные ответы $rightAnswer"
        mDialogView.findViewById<TextView>(R.id.wrong_an_tv).text = "Неверные ответы $wrongAnswer"
        mDialogView.findViewById<TextView>(R.id.apply_btn).setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    private fun showDialog() {
        val mDialogView =
            LayoutInflater.from(requireContext()).inflate(R.layout.answer_dialog, null)
        val mBuilder = AlertDialog.Builder(requireContext()).setView(mDialogView)
            .setTitle(result)
        val mAlertDialog = mBuilder.show()
        mDialogView.findViewById<TextView>(R.id.description).text = description
        mDialogView.findViewById<TextView>(R.id.my_question).text = question
        mDialogView.findViewById<Button>(R.id.apply_btn).setOnClickListener {
            if (currentLevel == 20) {
                mAlertDialog.dismiss()
                showResultDialog()
                requireContext().toastShow("20")
            } else {
                viewModel.getLevel(1 + currentLevel++).observe(viewLifecycleOwner, { level ->
                    val model = level[0]
                    levelNumber = model.id.toString()
                    description = model.description.toString()
                    firstAnswer = model.firstOp.toString()
                    secondAnswer = model.secondOp.toString()
                    thirdAnswer = model.thirdOp.toString()
                    fourAnswer = model.fourOp.toString()
                    answerQuestion = model.answer.toString()
                    question = model.question.toString()
                    setData()
                    firstButton()
                    secondButton()
                    thirdButton()
                    fourButton()
                }
                )
                mAlertDialog.dismiss()
            }
        }
    }
}