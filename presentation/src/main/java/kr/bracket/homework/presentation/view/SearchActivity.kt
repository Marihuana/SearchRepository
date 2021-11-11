package kr.bracket.homework.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import kr.bracket.homework.presentation.R
import kr.bracket.homework.presentation.databinding.ActivitySearchBinding
import kr.bracket.homework.presentation.viewmodel.SearchViewModel

class SearchActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding
    private val viewModel : SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)

    }
}