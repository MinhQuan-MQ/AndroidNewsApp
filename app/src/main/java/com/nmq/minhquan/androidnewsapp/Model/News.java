package com.nmq.minhquan.androidnewsapp.Model;

import java.util.List;

public class News {
    private String status;
    private String source;
    private String sortBy;
    private List<Article> articles;

    public String getStatus() {
        return status;
    }

    public News setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getSource() {
        return source;
    }

    public News setSource(String source) {
        this.source = source;
        return this;
    }

    public String getSortBy() {
        return sortBy;
    }

    public News setSortBy(String sortBy) {
        this.sortBy = sortBy;
        return this;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public News setArticles(List<Article> articles) {
        this.articles = articles;
        return this;
    }
}
