    package com.lawlett.yourquiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lawlett.yourquiz.R
import com.lawlett.yourquiz.core.BaseFragment
import com.lawlett.yourquiz.databinding.FragmentStartBinding
import com.lawlett.yourquiz.room.data.GameLevel
import com.lawlett.yourquiz.utils.LevelPreference
import com.lawlett.yourquiz.utils.StartPreference
import com.lawlett.yourquiz.viewmodels.GameViewModel
import org.koin.android.ext.android.inject


class StartFragment : BaseFragment(R.layout.fragment_start) {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private val viewModel by inject<GameViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkDataBase()
        LevelPreference.getInstance(requireContext())!!.clearShown()
    }

    private fun checkDataBase() {
        var isShown: Boolean = StartPreference.getInstance(requireContext())!!.isShown
        if (isShown) {
            binding.startBtn.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_gameFragment)
            }
        } else {
            insertToDataBase()
        }
    }
    private fun insertToDataBase() {
        binding.startBtn.setOnClickListener {
            val first = GameLevel(
                id = 1,
                question = "В каком году придумали юбки?",
                firstOp = "1642",
                secondOp = "1701",
                thirdOp = "1803",
                fourOp = "1904",
                answer = "1701",
                description = "Средние века и Возрождение В одежде юбка появилась в течение XV—XVI веков, когда сформировался новый принцип кроя одежды и юбка была отделена от лифа. ... В Италии в XV веке было распространено женское платье с узким небольшим по высоте лифом и отрезной юбкой, заложенной мягкими складками — так называемая гамурра."
            )
            val second = GameLevel(
                id = 2,
                question = "Шарик из мягкого материала на головном уборе?",
                firstOp = "Шарик",
                secondOp = "Пикчу",
                thirdOp = "Помпон",
                fourOp = "Помподур",
                answer = "Помпон",
                description = "Изначально это было украшение из ниток в виде шара. Впервые оно появилось на шапках французских моряков в XVIII веке: тогда использовали белые помпоны на красных шапках. Их начали пришивать по необходимости. ... Служащие флота нередко ударялись головами о потолки, и помпон был призван предохранять голову от удара."
            )
            val third = GameLevel(
                id = 3,
                question = "Cтрана зарождения моды?",
                firstOp = "Италия",
                secondOp = "Франция",
                thirdOp = "Бельгия",
                fourOp = "Россия",
                answer = "Франция",
                description = "Мода в одежде, как глобальное явление, начала формироваться во Франции в XVII в. Одежда же появилась на самых ранних этапах развития человечества. Об этом рассказали археологические раскопки."
            )
            val four = GameLevel(
                id = 4,
                question = "Коко Шанель кто она ?",
                firstOp = "Французский модельер",
                secondOp = "Шведский физик",
                thirdOp = "Итальянский парфюмер",
                fourOp = "Итальяский архитектор",
                answer = "Французский модельер",
                description = "Габриэ́ль Бонёр Шане́ль — французский модельер, основатель модного дома Chanel. Оказала существенное влияние на европейскую моду XX века; единственный человек из мира моды, кого журнал «Тайм» внёс в список ста самых влиятельных людей XX века."
            )
            val five = GameLevel(
                id = 5,
                question = "Кто придумал бантик?",
                firstOp = "Коко Шанель",
                secondOp = "Савиньон",
                thirdOp = "Ив Сен Лоран",
                fourOp = "Мадам де Севинье",
                answer = "Мадам де Севинье",
                description = "Однако, вернемся в XVII век и во Францию — ведь именно тогда начался настоящий «бум» бантов и бантиков. А произошло это благодаря тоже очень знаменитой даме, мадам де Севинье. Именно она придумала элегантную брошь в виде банта, названную впоследствии ее именем."
            )
            val six = GameLevel(
                id = 6,
                question = "Кто изобрел пиджак?",
                firstOp = "Жак",
                secondOp = "Поль",
                thirdOp = "Орехов",
                fourOp = "Мохов",
                answer = "Жак",
                description = "Исходя из французского происхождения слова «jaquette» можно сделать вывод, что первый жакет сшил француз, им оказался портной Жак, создавший на основе мужской модели «пи де Жак» (мужской пиджак), укороченный женский вариант этой верхней одежды."
            )
            val seven = GameLevel(
                id = 7,
                question = "Когда были изобретены перчатки?",
                firstOp = "13-14 века",
                secondOp = "17-18 века",
                thirdOp = "19-20 века",
                fourOp = "12-13 века",
                answer = "13-14 века",
                description = "В Германии и скандинавских странах перчатки появились в XIII – XIV веках. В 17 веке вместе с появлением вязаных чулок и изобретением вязальной машины, в обиход входят вязаные перчатки. С начала XVII-го и до конца XVIII-го столетия на рынке перчаток лидировали французские мастера."
            )
            val eight = GameLevel(
                id = 8,
                question = "Кто был первым дизайнером в мире?",
                firstOp = "Вайнштейн",
                secondOp = "Жан поль",
                thirdOp = "Жак Дусе",
                fourOp = "Коль Кей",
                answer = "Жак Дусе",
                description = "Жак Дусе (1853-1929) наряду с Чарльзом Вортом был творцом эпохи, любимым дизайнером актрис и титулованных особ."
            )
            val nine = GameLevel(
                id = 9,
                question = "Какой самый популярный цвет в мире?",
                firstOp = "красно-желтый",
                secondOp = "синий",
                thirdOp = "сапфировый",
                fourOp = "зелено-синий",
                answer = "зелено-синий",
                description = "Десятки тысяч людей из более сотни стран проголосовали за свой любимый цвет. Нет, это не черный. Вот и он: Им стал глубокий зелено-синий цвет, вызывающий ассоциации со спокойствием и природой, названный Marrs Green."
            )
            val ten = GameLevel(
                id = 10,
                question = "Где была основана zara",
                firstOp = "Испания",
                secondOp = "Италия",
                thirdOp = "Швеция",
                fourOp = "Франция",
                answer = "Испания",
                description = "24 мая 1974 г., Ла-Корунья, Испания"
            )
            val eleven = GameLevel(
            id = 11,
            question = "Самый не красивый цвет в мире?",
            firstOp = "серый",
            secondOp = "темно-коричневый",
            thirdOp = "коричневый",
            fourOp = "белый",
            answer = "темно-коричневый",
            description = "Самый ужасный в мире цвет — темно-коричневый Pantone 448 C — описывают как \"смерть\" и \"грязь\". Об этом стало известно из исследования компании GfK, сделанного по заказу правительства Австралии. Теперь этот \"отвратительный\" цвет будут использовать для оформления всех пачек сигарет в Австралии."
        )
            val twelve = GameLevel(
                id = 12,
                question = "Кому принадлежит компания ZARA",
                firstOp = "Амансио Ортеге",
                secondOp = "Харви Вайнштейн",
                thirdOp = "Джей Джей",
                fourOp = "Октавиан Август",
                answer = "Амансио Ортеге",
                description = "За́ра — ведущая торговая сеть группы компаний Inditex, принадлежит испанскому магнату Амансио Ортеге, который также является владельцем таких брендов как Massimo Dutti, Pull and Bear, Oysho, Zara Home, Uterqüe, Stradivarius, Lefties и Bershka."
            )
            val thirteen = GameLevel(
                id = 13,
                question = "В каком году была основона компания Chanel ",
                firstOp = "1910",
                secondOp = "1812",
                thirdOp = "1970",
                fourOp = "1978",
                answer = "1910",
                description = "1910 г., Париж, Франция/Chanel S. A. — французская компания по производству одежды и предметов роскоши, основанная модельером Коко Шанель в Париже в начале XX века. Компания принадлежит Алену Вертхаймеру и Жерару Вертхаймеру, внукам Пьера Вертхаймера, который был деловым партнером Коко Шанель."
            )
            val fourteen = GameLevel(
                id = 14,
                question = "Где находится штаб-квартира Louis Vuitton",
                firstOp = "Милан",
                secondOp = "Рим",
                thirdOp = "Париж",
                fourOp = "Мадрид",
                answer = "Париж",
                description = "Париж,Франция/Louis Vuitton — французский дом моды, специализирующийся на производстве чемоданов и сумок, модной одежды, парфюмерии и аксессуаров класса «люкс» под одноимённой торговой маркой. В настоящее время компания является частью международного холдинга LVMH"
            )
            val fiveteen = GameLevel(
                id = 15,
                question = "Где находится штаб-квартира Prada",
                firstOp = "Париж",
                secondOp = "Милан",
                thirdOp = "Мадрид",
                fourOp = "Рим",
                answer = "Милан",
                description = "Prada — итальянская публичная компания, специализирующаяся на производстве модной одежды, обуви и аксессуаров, которой принадлежат одноимённые дом моды и торговая марка. Штаб-квартира расположена в Милане."
            )
            val sixteen = GameLevel(
                id = 16,
                question = "Чем занимается комания Cartier",
                firstOp = "Ювелирными изделиями",
                secondOp = "Духами",
                thirdOp = "Одеждой",
                fourOp = "Машинами",
                answer = "Ювелирными изделиями",
                description = "CARTIER International SNC или просто Cartier — французский дом по производству часов и ювелирных изделий. Он был основан в 1847 году Луи-Франсуа Картье в Париже, компания оставалась под управлением семьи до 1964 года."
            )
            val seventeen = GameLevel(
                id = 17,
                question = "Имена основателей Dolce & Gabbana",
                firstOp = "Альберто и Джеронимо",
                secondOp = "Гуерино и Джианни",
                thirdOp = "Джузеппе и Касимиро",
                fourOp = "Доменико и Стефано",
                answer = "Доменико и Стефано",
                description = "Dolce & Gabbana — итальянский дом моды, основанный в 1985 году модельерами Доменико Дольче и Стефано Габбана."
            )
            val eighteen = GameLevel(
                id = 18,
                question = "Какой цвет больше всего сочетается с фиолетовым?",
                firstOp = "с чёрным",
                secondOp = "с синим",
                thirdOp = "с розовым",
                fourOp = "с белым",
                answer = "с розовым",
                description = "Фиолетовый сочетается с розовым: сакурой, клубничным, кораллово-розовым, маджентой, пурпурно-розовым. Поддерживающие нейтральные оттенки: светло-кремовый, средний розово-бежевый, черно-серый. Ярко-фиолетовый сочетается с розовым: бело-лиловым, гвоздикой, закатно-розовым, цветом Барби, малиновым."
            )
            val nineteen = GameLevel(
                id = 19,
                question = "Что входит в теплые цвета?",
                firstOp = "Красный,жёлтый,оранжевый",
                secondOp = "Синий,голубой,сиреневый",
                thirdOp = "белый,серый",
                fourOp = "фиолетовый,чёрный",
                answer = "Красный,жёлтый,оранжевый",
                description = "Соответственно, те цвета, в которых преобладают красный и желтый, считаются теплыми (оранжевый, красный, желтый)"
            )
            val twenty = GameLevel(
                id = 20,
                question = "Что входит в холодные цвета?",
                firstOp = "белый,серый",
                secondOp = "фиолетовый,чёрный",
                thirdOp = "Красный,жёлтый,оранжевый",
                fourOp = "синий, голубой, сиреневый",
                answer = "синий, голубой, сиреневый",
                description = "Те же, в которых преобладает синий цвет (синий, голубой, сиреневый), считаются холодными."
            )
//            val twentyOne = GameLevel(
//                id = 21,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentyTwo = GameLevel(
//                id = 22,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentyThird = GameLevel(
//                id = 23,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentyFour = GameLevel(
//                id = 24,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentyFive = GameLevel(
//                id = 25,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentySix = GameLevel(
//                id = 26,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentySeven = GameLevel(
//                id = 27,
//                question = "",
//                firstOp = "",
//                secondOp = "",
//                thirdOp = "",
//                fourOp = "",
//                answer = "",
//                description = ""
//            )
//            val twentyEight = GameLevel(
//            id = 28,
//            question = "",
//            firstOp = "",
//            secondOp = "",
//            thirdOp = "",
//            fourOp = "",
//            answer = "",
//            description = ""

            viewModel.addLevel(first)
            viewModel.addLevel(second)
            viewModel.addLevel(third)
            viewModel.addLevel(four)
            viewModel.addLevel(five)
            viewModel.addLevel(six)
            viewModel.addLevel(seven)
            viewModel.addLevel(eight)
            viewModel.addLevel(nine)
            viewModel.addLevel(ten)
            viewModel.addLevel(eleven)
            viewModel.addLevel(twelve)
            viewModel.addLevel(thirteen)
            viewModel.addLevel(fourteen)
            viewModel.addLevel(fiveteen)
            viewModel.addLevel(sixteen)
            viewModel.addLevel(seventeen)
            viewModel.addLevel(eighteen)
            viewModel.addLevel(nineteen)
            viewModel.addLevel(twenty)
//            viewModel.addLevel(twentyOne)
//            viewModel.addLevel(twentyTwo)
//            viewModel.addLevel(twentyThird)
//            viewModel.addLevel(twentyFour)
//            viewModel.addLevel(twentyFive)
//            viewModel.addLevel(twentySix)
//            viewModel.addLevel(twentySeven)
//            viewModel.addLevel(twentyEight)

            StartPreference.getInstance(requireContext())!!.saveShown()
            findNavController().navigate(R.id.action_startFragment_to_gameFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}