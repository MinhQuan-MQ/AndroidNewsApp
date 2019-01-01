package com.nmq.minhquan.androidnewsapp.Interface;

import com.nmq.minhquan.androidnewsapp.Common.Common;
import com.nmq.minhquan.androidnewsapp.Model.News;
import com.nmq.minhquan.androidnewsapp.Model.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NewsService {
    @GET("v2/sources?language=en&apiKey="+Common.API_KEY)
    Call<WebSite> getSources();

    @GET
    Call<News> getNewestArticles(@Url String url);
}
