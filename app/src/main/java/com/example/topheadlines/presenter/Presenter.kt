package com.example.topheadlines.presenter

import android.util.Log
import android.view.View
import com.example.topheadlines.common.Constants
import com.example.topheadlines.model.TopHeadlines
import com.example.topheadlines.network.TopHeadlineAPIInterface
import com.example.topheadlines.network.TopHeadlineRetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class Presenter(_view: FragmentInterface) : PresenterInterface{

    var view = _view

    override fun onViewAttached() {
        var retrofit = TopHeadlineRetrofitInstance().getTopHeadlineRetrofitInstance().create(TopHeadlineAPIInterface::class.java)
        var call = retrofit.getTopHeadlines(Constants.COUNTRY, Constants.API_KEY)

        call.enqueue(object : Callback<TopHeadlines?>{
            override fun onFailure(call: Call<TopHeadlines?>, t: Throwable) {
                Log.d("NETWORK FAILURE", t.message)
            }

            override fun onResponse(call: Call<TopHeadlines?>, response: Response<TopHeadlines?>) {
                var data: TopHeadlines? = response.body()



                view.showData(data)
            }

        })

    }


    override fun getModel() {

    }

}