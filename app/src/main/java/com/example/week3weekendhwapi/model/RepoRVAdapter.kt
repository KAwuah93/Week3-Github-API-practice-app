package com.example.week3weekendhwapi.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.week3weekendhwapi.R
import com.example.week3weekendhwapi.Repository
import kotlinx.android.synthetic.main.repo_item_layout.view.*

import java.util.ArrayList

class RepoRVAdapter(val repositories: List<Repository>) : RecyclerView.Adapter<RepoRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoRVAdapter.ViewHolder {
        val inflatedItem = LayoutInflater.from(parent.context).inflate(R.layout.repo_item_layout, parent, false)
        return ViewHolder(inflatedItem)
    }

    override fun onBindViewHolder(holder: RepoRVAdapter.ViewHolder, position: Int) {
        val currentRepo = repositories[position]
        holder.populateValues(currentRepo)
    }

    override fun getItemCount(): Int = repositories.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var repo: Repository

        fun setRepoItem(repoItem: Repository) {
            this.repo = repoItem
        }

        fun populateValues(repository: Repository) {
            //Set everything
            itemView.tvRepoTitle.text = repository.name
            itemView.tvRepoLanguage.text = repository.language
            itemView.repoSize.text = "Size of Repo: " + repository.size
            itemView.tvRepoDate.text = repository.createdAt!!.substring(0, 10)
            setRepoItem(repository)
        }
        override fun onClick(view: View) {
        }
    }

    companion object {
        val TAG = "TAG_AnimalRVAdapter"
    }
}
