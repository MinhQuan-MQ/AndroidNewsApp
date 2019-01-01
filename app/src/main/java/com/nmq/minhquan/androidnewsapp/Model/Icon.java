package com.nmq.minhquan.androidnewsapp.Model;

public class Icon {
    private String url;
    private int width, height, bytes;
    private String format, sha1sum;
    private Object error;

    public String getUrl() {
        return url;
    }

    public Icon setUrl(String url) {
        this.url = url;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public Icon setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public Icon setHeight(int height) {
        this.height = height;
        return this;
    }

    public int getBytes() {
        return bytes;
    }

    public Icon setBytes(int bytes) {
        this.bytes = bytes;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public Icon setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getSha1sum() {
        return sha1sum;
    }

    public Icon setSha1sum(String sha1sum) {
        this.sha1sum = sha1sum;
        return this;
    }

    public Object getError() {
        return error;
    }

    public Icon setError(Object error) {
        this.error = error;
        return this;
    }
}
