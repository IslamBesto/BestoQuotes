package com.example.saidi.bestoquotes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.saidi.bestoquotes.R
import com.example.saidi.bestoquotes.model.Competition
import kotlinx.android.synthetic.main.view_competition_item.view.*

class CompetitionAdapter(
    var mCompetition: List<Competition>? = null,
    var mItemClickListener: ItemClickListener? = null
) :
    RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_competition_item, parent, false)
        return CompetitionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mCompetition?.size ?: 0
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.bind(mCompetition?.get(position))
    }

    fun setCompetitionData(competition: List<Competition>?) {
        mCompetition = competition
        notifyDataSetChanged()
    }


    inner class CompetitionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        override fun onClick(view: View?) {
            mItemClickListener?.onItemClickListener()
        }

        fun bind(competition: Competition?) {
            itemView.setOnClickListener(this)
            itemView.competitionName.text = competition?.name
        }

    }

    interface ItemClickListener {
        fun onItemClickListener()
    }
}

