package com.example.dictionary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dictionary.database.FavoriteListData
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment()  {
    private var rv: RecyclerView?=null
    private var adapter: FavoriteAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favourite, container, false)

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv = fav_recyclerview
        rv!!.setHasFixedSize(true)
        rv!!.layoutManager = LinearLayoutManager(requireActivity())
        getfavData()

    }

    private fun getfavData(){
            val favoriteLists: List<FavoriteListData?>? =
                SearchFragment.favoriteDatabase?.favoriteDao()?.getFavoriteData()
            adapter = FavoriteAdapter(requireActivity(),favoriteLists)
            rv!!.adapter = adapter


        }
}




