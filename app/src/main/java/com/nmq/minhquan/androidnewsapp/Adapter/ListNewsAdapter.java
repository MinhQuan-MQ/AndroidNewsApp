package com.nmq.minhquan.androidnewsapp.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.nmq.minhquan.androidnewsapp.Common.ISO8601Parse;
import com.nmq.minhquan.androidnewsapp.DetailArticle;
import com.nmq.minhquan.androidnewsapp.Interface.ItemClickListener;
import com.nmq.minhquan.androidnewsapp.Model.Article;
import com.nmq.minhquan.androidnewsapp.R;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class ListNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ItemClickListener itemClickListener;
    TextView article_title;
    RelativeTimeTextView article_time;
    CircleImageView article_image;

    public ListNewsViewHolder(View itemView) {
        super(itemView);
        article_image = (CircleImageView)itemView.findViewById(R.id.article_image);
        article_title = (TextView)itemView.findViewById(R.id.article_title);
        article_time = (RelativeTimeTextView)itemView.findViewById(R.id.article_time);
        itemView.setOnClickListener(this);
    }

    public ListNewsViewHolder setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        return this;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view, getAdapterPosition(), false);
    }
}

public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsViewHolder>{
    private List<Article> articleList;
    private Context context;

    public ListNewsAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_layout, parent, false);
        return new ListNewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsViewHolder holder, int position) {
        String imageURL = articleList.get(position).getUrlToImage();
        if(imageURL != null && !imageURL.trim().isEmpty()){
            Picasso.with(context)
                    .load(imageURL)
                    .into(holder.article_image);
        }
        if(articleList.get(position).getTitle().length() > 65){
            String tmpTitle = articleList.get(position).getTitle().substring(0, 65) + "...";
            holder.article_title.setText(tmpTitle);
        }else{
            holder.article_title.setText(articleList.get(position).getTitle());
        }
        Log.e("DateTime", articleList.get(position).getPublishedAt());
        String tmpTime = articleList.get(position).getPublishedAt();
        if(tmpTime.contains(".")){
            tmpTime = tmpTime.substring(0, 19) + "Z";
        }
        Date date = new Date();
        try{
            date = ISO8601Parse.parse(tmpTime);
        }catch(ParseException ex){
            date.setTime(1200);
            ex.printStackTrace();
        }
        holder.article_time.setReferenceTime(date.getTime());
        // Set Events Click
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent detail = new Intent(context, DetailArticle.class);
                detail.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                detail.putExtra("webURL", articleList.get(position).getUrl());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
