package com.example.tics.rssreader;

import android.annotation.SuppressLint;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.prof.rssparser.Article;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FeedAdapter extends ArrayAdapter<Article> {

    RequestOptions options = new RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher_round)
            .error(R.mipmap.ic_launcher_round);

    public FeedAdapter(Context context, ArrayList<Article> object) {

        super(context, 0, object);

    }

    //@SuppressLint("ViewHolder")
    //@NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Article dataSource = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.second_view_data,parent, false);
        }
        // Lookup view for data population
        TextView titleTxt = convertView.findViewById(R.id.titleTextView);
        TextView descriptionTxt = convertView.findViewById(R.id.descriptionTextView);
        ImageView articleImg = convertView.findViewById(R.id.articleImageView);
        // Populate the data into the template view using the data object
        titleTxt.setText(dataSource.getTitle());
        descriptionTxt.setText(dataSource.getDescription());
        String ver = dataSource.getImage();
        Glide.with(getContext()).load(dataSource.getImage()).apply(options).into(articleImg);
        //articleImg.setImageURI(dataSource.getImage());
        // Return the completed view to render on screen
        return convertView;
    }
}
