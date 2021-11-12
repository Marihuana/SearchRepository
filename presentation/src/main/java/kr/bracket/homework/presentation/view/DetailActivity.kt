package kr.bracket.homework.presentation.view

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.google.android.material.internal.ViewUtils.dpToPx
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.presentation.R
import kr.bracket.homework.presentation.databinding.ActivityDetailBinding
import kr.bracket.homework.presentation.viewmodel.DetailViewModel
import kotlin.math.roundToInt

class DetailActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailBinding
    private val viewModel : DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.apply {
            this.lifecycleOwner = this@DetailActivity
            this.item = object : RepoVO{
                override val name: String
                    get() = "name"
                override val fullName: String
                    get() = "fullName"
                override val description: String
                    get() = "description"
                override val topics: List<String>
                    get() = listOf("topic1","sdfjkldfj","asdfghs","hahahahahaha","123123123123",)
                override val stargazersCount: Double
                    get() = 0.0
                override val license: String?
                    get() = "license"
                override val language: String?
                    get() = "language"
                override val updatedAt: Long?
                    get() = 0L
            }
        }

    }


    private fun redirect(url : String){
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

}