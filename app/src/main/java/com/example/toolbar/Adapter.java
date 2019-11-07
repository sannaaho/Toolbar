package com.example.toolbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Picture> {

    private Context context;
    private int layoutResourceId;
    private ArrayList<Picture> itemList;

    public Adapter(Context context, int layoutResourceId, ArrayList<Picture> itemList) {
        super(context, layoutResourceId, itemList);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.itemList = itemList;
    }

    private class ViewHolder {
        TextView textViewUrl;
        TextView textViewName;
        ImageView imgView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();

        final ViewHolder viewHolder;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.list, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.textViewUrl = convertView.findViewById(R.id.textViewUrl);
            viewHolder.textViewName = convertView.findViewById(R.id.textViewName);
            viewHolder.imgView = convertView.findViewById(R.id.imgView);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        System.out.println(position);
        viewHolder.textViewName.setText("License: " + itemList.get(position));
        viewHolder.textViewUrl.setText("Owner: " + itemList.get(position));

        Picasso.get().load(itemList.get(position).getUrl()).into(viewHolder.imgView);

        return convertView;

    }
}