package com.example.dictionary

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.database.FavoriteListData
import kotlinx.android.synthetic.main.activity_recycler_adapter.view.*
import org.jetbrains.annotations.NotNull

class RecyclerAdapter(val context: Context,val userList:List<RecyclerData>,val listener:OnWordClickListener):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {

        var title: TextView
        var btn: ImageView
        var synonyms: TextView
        var examples: TextView


        init {
            title = itemview.main_title
            btn = itemview.fav_Btn
            synonyms = itemview.main_synonyms
            examples = itemview.main_example


        }

        fun initialize(item: RecyclerData, action: OnWordClickListener) {
            title.text = item.word
            synonyms.text = item.synonyms
            examples.text = item.example

            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)

            }
        }
    }



    override fun onCreateViewHolder(@NotNull parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview=
            LayoutInflater.from(context).inflate(R.layout.activity_recycler_adapter,parent,false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(@NotNull holder: ViewHolder, position: Int) {
        val recyclerData: RecyclerData = userList.get(position)
        //holder.title.text= userList[position].word
        holder.initialize(userList.get(position),listener)

        val user_list:RecyclerData=userList[position]
        if (SearchFragment.favoriteDatabase?.favoriteDao()?.isFavorite(user_list.id)==1){
            holder.btn.setImageResource(R.drawable.heart_selected)
        }
        else {
            holder.btn.setImageResource(R.drawable.heart_notselected)
        }
        holder.btn.setOnClickListener {
            val favoriteListData = FavoriteListData(userList[position].id,userList[position].word)
            val id: Int = recyclerData.getId()
            val word: String? =recyclerData.getWord()
            favoriteListData.setId(id)
            if (word != null) {
                favoriteListData.setWord(word)
            }


            if (SearchFragment.favoriteDatabase?.favoriteDao()?.isFavorite(id) != 1) {
                    holder.btn.setImageResource(R.drawable.heart_selected)
                    SearchFragment.favoriteDatabase?.favoriteDao()?.addData(favoriteListData)

                } else {
                    holder.btn.setImageResource(R.drawable.heart_notselected)
                    SearchFragment.favoriteDatabase?.favoriteDao()?.delete(favoriteListData)

                }


        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    interface OnWordClickListener {
        fun onItemClick(item:RecyclerData,position: Int) {


        }
    }


}





