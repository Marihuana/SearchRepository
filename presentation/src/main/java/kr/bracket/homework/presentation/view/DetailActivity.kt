package kr.bracket.homework.presentation.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.presentation.R
import kr.bracket.homework.presentation.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityDetailBinding

    private var repo : RepoVO? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repo = intent.getSerializableExtra("repo") as RepoVO

        if(repo == null) {
            //잘못된 접근
            finish()
        }else {
            binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
            binding.apply {
                this.lifecycleOwner = this@DetailActivity
                this.item = repo
            }
            init()
        }
    }

    private fun init(){
        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.tvFullName.setOnClickListener{
            repo?.run {
                redirect("https://github.com/$fullName")
            }
        }
    }

    private fun redirect(url : String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }
}