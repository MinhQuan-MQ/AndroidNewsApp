package com.nmq.minhquan.androidnewsapp.Model;

import java.util.List;

class UrlsToLogos{
    private String small, medium, large;

    public String getSmall() {
        return small;
    }

    public UrlsToLogos setSmall(String small) {
        this.small = small;
        return this;
    }

    public String getMedium() {
        return medium;
    }

    public UrlsToLogos setMedium(String medium) {
        this.medium = medium;
        return this;
    }

    public String getLarge() {
        return large;
    }

    public UrlsToLogos setLarge(String large) {
        this.large = large;
        return this;
    }
}


public class Source {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
//    private UrlsToLogos urlsToLogos;
//    private List<String> sortBysAvailable;

    public Source() {
    }

    public Source(String id, String name, String description, String url, String category, String language, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.category = category;
        this.language = language;
        this.country = country;
//        this.urlsToLogos = urlsToLogos;
//        this.sortBysAvailable = sortBysAvailable;
    }

    public String getId() {
        return id;
    }

    public Source setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Source setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Source setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Source setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Source setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Source setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Source setCountry(String country) {
        this.country = country;
        return this;
    }

//    public UrlsToLogos getUrlsToLogos() {
//        return urlsToLogos;
//    }
//
//    public Source setUrlsToLogos(UrlsToLogos urlsToLogos) {
//        this.urlsToLogos = urlsToLogos;
//        return this;
//    }
//
//    public List<String> getSortBysAvailable() {
//        return sortBysAvailable;
//    }
//
//    public Source setSortBysAvailable(List<String> sortBysAvailable) {
//        this.sortBysAvailable = sortBysAvailable;
//        return this;
//    }
}
