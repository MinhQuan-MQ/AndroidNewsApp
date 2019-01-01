package com.nmq.minhquan.androidnewsapp;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.nmq.minhquan.androidnewsapp.Adapter.ListNewsAdapter;
import com.nmq.minhquan.androidnewsapp.Common.Common;
import com.nmq.minhquan.androidnewsapp.Interface.NewsService;
import com.nmq.minhquan.androidnewsapp.Model.Article;
import com.nmq.minhquan.androidnewsapp.Model.News;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListNews extends AppCompatActivity {

    KenBurnsView kenBurnsView;
    DiagonalLayout diagonalLayout;
    SpotsDialog dialog;
    NewsService mService;
    TextView top_author, top_title;
    SwipeRefreshLayout swipeRefreshLayout;
    String source = "", sortBy = "", webHotURL = "";
    ListNewsAdapter adapter;
    RecyclerView lstNews;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_news);
        // Service
        mService = Common.getNewsService();

        dialog = new SpotsDialog(this);
        // View
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.news_swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadNews(source, true);
            }
        });

        diagonalLayout = (DiagonalLayout)findViewById(R.id.diagonalLayout);
        diagonalLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click to hot / lastest news to read
                Intent detail = new Intent(getBaseContext(), DetailArticle.class);
                detail.putExtra("webURL", webHotURL);
                startActivity(detail);
            }
        });
        kenBurnsView = (KenBurnsView)findViewById(R.id.top_image);
        top_author = (TextView)findViewById(R.id.top_author);
        top_title = (TextView)findViewById(R.id.top_title);

        lstNews = (RecyclerView)findViewById(R.id.lstNews);
        lstNews.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        lstNews.setLayoutManager(layoutManager);

        // Intent
        if(getIntent() != null){
            source = getIntent().getStringExtra("source");
            if(!source.isEmpty()){
                loadNews(source, false);
            }
        }
    }

    private void loadNews(String source, boolean isRefreshed){
        if(!isRefreshed){
            dialog.show();
            mService.getNewestArticles(Common.getAPIUrl(source, sortBy, Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            // Get first article
                            Article articleFirst = response.body().getArticles().get(0);
                            String imageURL = articleFirst.getUrlToImage();
                            if(imageURL != null && !imageURL.trim().isEmpty()){
                                Picasso.with(getBaseContext())
                                        .load(imageURL)
                                        .into(kenBurnsView);
                            }
                            top_title.setText(articleFirst.getTitle());
                            top_author.setText(articleFirst.getAuthor());
                            webHotURL = articleFirst.getUrl();

                            // Load remain articles
                            List<Article> removeFirstItem = response.body().getArticles();
                            List<Integer> emptyTime = new ArrayList<>();
                            // Because we already load first item to show on Diagonal Layout
                            // So we need romove it
                            removeFirstItem.remove(0);
                            adapter = new ListNewsAdapter(removeFirstItem, getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
        }else{
            dialog.show();
            mService.getNewestArticles(Common.getAPIUrl(source, sortBy, Common.API_KEY))
                    .enqueue(new Callback<News>() {
                        @Override
                        public void onResponse(Call<News> call, Response<News> response) {
                            dialog.dismiss();
                            // Get first article
                            Article articleFirst = response.body().getArticles().get(0);
                            String imageURL = articleFirst.getUrlToImage();
                            if(imageURL != null && !imageURL.trim().isEmpty()){
                                Picasso.with(getBaseContext())
                                        .load(imageURL)
                                        .into(kenBurnsView);
                            }
                            top_title.setText(articleFirst.getTitle());
                            top_author.setText(articleFirst.getAuthor());
                            webHotURL = articleFirst.getUrl();

                            // Load remain articles
                            List<Article> removeFirstItem = response.body().getArticles();
                            // Because we already load first item to show on Diagonal Layout
                            // So we need romove it
                            removeFirstItem.remove(0);
                            adapter = new ListNewsAdapter(removeFirstItem, getBaseContext());
                            adapter.notifyDataSetChanged();
                            lstNews.setAdapter(adapter);
                        }

                        @Override
                        public void onFailure(Call<News> call, Throwable t) {

                        }
                    });
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
