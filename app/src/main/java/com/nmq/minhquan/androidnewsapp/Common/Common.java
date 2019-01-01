package com.nmq.minhquan.androidnewsapp.Common;

import com.nmq.minhquan.androidnewsapp.Interface.IconBetterIdeaService;
import com.nmq.minhquan.androidnewsapp.Interface.NewsService;
import com.nmq.minhquan.androidnewsapp.Model.IconBetterIdea;
import com.nmq.minhquan.androidnewsapp.Remote.IconBetterIdeaClient;
import com.nmq.minhquan.androidnewsapp.Remote.RetrofitClient;

import retrofit2.Retrofit;

public class Common {
    private static final String BASE_URL = "http://newsapi.org/";
    public static final String API_KEY = "c5624ed18401495f987118006314877b";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService(){
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    public static String getAPIUrl(String source, String sortBy, String apiKEY){
        StringBuilder apiUrl = new StringBuilder("http://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(apiKEY).toString();
    }
}
