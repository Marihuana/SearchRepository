package kr.bracket.homework.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.presentation.databinding.ItemRepoBinding

class RepoViewHolder (
    private val binding : ItemRepoBinding,
    private val listener : (RepoVO)-> Unit)
    : RecyclerView.ViewHolder(binding.root){

    fun bind(item : RepoVO){
        binding.item = item
        binding.root.setOnClickListener {
            listener(item)
        }
    }
}