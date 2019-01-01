package com.nmq.minhquan.androidnewsapp.Model;

import java.util.List;

public class WebSite {
    private String status;
    private List<Source> sources;

    public WebSite() {
    }

    public WebSite(String status, List<Source> sources) {
        this.status = status;
        this.sources = sources;
    }

    public String getStatus() {
        return status;
    }

    public WebSite setStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Source> getSources() {
        return sources;
    }

    public WebSite setSources(List<Source> sources) {
        this.sources = sources;
        return this;
    }
}
