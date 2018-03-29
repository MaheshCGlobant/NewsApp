package com.globant.newsapp.feature.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.globant.newsapp.Article
import com.globant.newsapp.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.MainView {

    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        presenter.getNewsList("us","business")
        presenter.getString()
    }

    override fun setName(name:String) {
        textView.setText(name)
    }

    override fun updateNews(list: List<Article>?, totalCount: Int) {
       for (item in list!!){
           Log.v("MainActivity", item.title)
       }
    }
}
