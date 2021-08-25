package com.example.dictionary


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.dictionary.database.FavoriteDatabase
import kotlinx.android.synthetic.main.activity_recycler_adapter.*
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment:Fragment(R.layout.fragment_search),RecyclerAdapter.OnWordClickListener {

    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    companion object {
        var favoriteDatabase: FavoriteDatabase?=null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

      /*  favBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                Toast.makeText(context,"Item added to Favorite",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context,"Item removed to Favorite",Toast.LENGTH_SHORT).show()
            }
        }*/

        favoriteDatabase = Room.databaseBuilder(requireActivity(),
            FavoriteDatabase::class.java, "myfavdb"
        ).allowMainThreadQueries().build()


        val apiService = ApiService.create().getphoto()
        apiService.enqueue(object : Callback<List<RecyclerData>> {
            override fun onResponse(call: Call<List<RecyclerData>>, response: Response<List<RecyclerData>>) {
                val responseBody = response.body()!!

                recyclerAdapter = RecyclerAdapter(requireContext(), responseBody,this@SearchFragment)
                recyclerAdapter.notifyDataSetChanged()
                recycler_view.setHasFixedSize(true)
                recycler_view.adapter = recyclerAdapter

                Toast.makeText(context, "successful", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<RecyclerData>>, t: Throwable) {
                Toast.makeText(context, "failure", Toast.LENGTH_LONG).show()
            }


        })

    }

    override fun onItemClick(item:RecyclerData, position: Int) {
        val intent = Intent(activity,InformationActivity::class.java)
        intent.putExtra("WORD",item.word)
        intent.putExtra("SYNONYMS",item.synonyms)
        intent.putExtra("EXAMPLE",item.example)
        startActivity(intent)

    }

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        linearLayoutManager = LinearLayoutManager(context)
        recycler_view.layoutManager = linearLayoutManager

    }


    

}


