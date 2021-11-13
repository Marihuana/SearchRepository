package kr.bracket.homework.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.bracket.homework.domain.model.RepoVO
import kr.bracket.homework.presentation.databinding.ItemRepoBinding
import kr.bracket.homework.presentation.view.viewholder.RepoViewHolder

class RepoAdapter (private val listener : (RepoVO)-> Unit) : PagingDataAdapter<RepoVO, RepoViewHolder>(diffCallback) {

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RepoViewHolder(
            ItemRepoBinding.inflate(layoutInflater, parent, false), listener
        )
    }

    companion object{
        private val diffCallback = object : DiffUtil.ItemCallback<RepoVO>(){
            override fun areItemsTheSame(oldItem: RepoVO, newItem: RepoVO): Boolean {
                return oldItem.fullName == newItem.fullName
            }

            override fun areContentsTheSame(oldItem: RepoVO, newItem: RepoVO): Boolean {
                return (oldItem.fullName == newItem.fullName)
            }
        }
    }

}