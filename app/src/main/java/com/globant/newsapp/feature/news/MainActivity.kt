package com.globant.newsapp.feature.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.globant.newsapp.Article
import com.globant.newsapp.R
import com.globant.newsapp.feature.news.adapter.NewsHeadlinesAdapter
import com.squareup.picasso.Picasso
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.MainView {


    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var picasso: Picasso

    lateinit var newsAdapter:NewsHeadlinesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter=NewsHeadlinesAdapter(this, picasso, ArrayList<Article>())
        recyclerViewNewsList?.adapter = newsAdapter

        presenter.getNewsList("us", "business")
        presenter.getString()
    }

    override fun setName(name: String) {

    }

    override fun updateNews(list: List<Article>?, totalCount: Int) {
        newsAdapter.updateList(list as ArrayList<Article>)
    }

    override fun error(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}
