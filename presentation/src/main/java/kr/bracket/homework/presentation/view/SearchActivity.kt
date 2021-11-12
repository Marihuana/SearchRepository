package kr.bracket.homework.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.presentation.R
import kr.bracket.homework.presentation.databinding.ActivitySearchBinding
import kr.bracket.homework.presentation.view.adapter.RepoAdapter
import kr.bracket.homework.presentation.viewmodel.SearchViewModel

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private val viewModel : SearchViewModel by viewModels()

    private lateinit var binding : ActivitySearchBinding
    private lateinit var recyclerView : RecyclerView
    private lateinit var imm : InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search)
        binding.apply {
            this.viewModel = this@SearchActivity.viewModel
            this.lifecycleOwner = this@SearchActivity
        }

        init()
        bind()
    }

    private fun init(){
        imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager

        recyclerView = binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = RepoAdapter(::onItemClicked)
            //adapter =
        }

        binding.etSearch.setOnEditorActionListener { view, action, _ ->
            if(action == EditorInfo.IME_ACTION_SEARCH) {
                viewModel.search()
                hideKeyboard(view)
                true
            } else false
        }
    }

    private fun bind(){
        viewModel.items.observe(this){
            (recyclerView.adapter as RepoAdapter).submitData(this.lifecycle, it)
        }

        viewModel.errorObserver.observe(this){ e ->
            e?.getContent()?.also {
                Toast.makeText(this@SearchActivity, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun hideKeyboard(view : View){
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun onItemClicked(item : RepoVO){
        Intent(this@SearchActivity, DetailActivity::class.java)
            .apply { putExtra("repo", item) }
            .run {
                startActivity(this)
            }
    }
}