package com.example.topheadlines.view.fragement


import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topheadlines.R
import com.example.topheadlines.model.Articles
import com.example.topheadlines.model.TopHeadlines
import com.example.topheadlines.presenter.FragmentInterface
import com.example.topheadlines.presenter.Presenter
import com.example.topheadlines.view.OnClickItemListener
import com.example.topheadlines.view.RecycleViewAdapter
import kotlinx.android.synthetic.main.fragment_recycle_view.*
import androidx.browser.customtabs.CustomTabsIntent

/**
 * A simple [Fragment] subclass.
 */
class RecycleViewFragment : Fragment(), FragmentInterface{

    override fun showData(topHeadlines: TopHeadlines?) {
        var adapter = RecycleViewAdapter(topHeadlines, object : OnClickItemListener{
            override fun onClick(result: Articles) {
                var url = result.url

                var builder = CustomTabsIntent.Builder()
                var customTabsIntent = builder.build()
                customTabsIntent.launchUrl(activity, Uri.parse(url))
            }

        })

        rv_main.layoutManager = LinearLayoutManager(activity?.applicationContext)
        rv_main.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycle_view, container, false)
    }

    var presenter = Presenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewAttached()

    }


}
