package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Avinash Tadavarthy on 07-Jul-17.
 */

public class CustomGridViewActivity extends BaseAdapter {

    private Context mContext;
    private final String[] gridViewString;
    private final int[] gridViewImageId;
    private final String[] certString;

    public CustomGridViewActivity(Context context, String[] gridViewString, String[] certString, int[] gridViewImageId) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.gridViewString = gridViewString;
        this.certString = certString;
    }

    @Override
    public int getCount() {
        return gridViewString.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridViewAndroid;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridViewAndroid = inflater.inflate(R.layout.gridview_layout,parent,false);

        } else {
            gridViewAndroid = (View) convertView;
        }

        TextView movie_name = (TextView) gridViewAndroid.findViewById(R.id.movie_name);
        TextView cert = (TextView) gridViewAndroid.findViewById(R.id.cert);
        ImageView movie_poster = (ImageView) gridViewAndroid.findViewById(R.id.movie_poster);
        movie_name.setText(gridViewString[position]);
        cert.setText(certString[position]);
        //Picasso.with(mContext).load(gridViewString[position]).resize(150,207).centerCrop().into(movie_poster);
        movie_poster.setImageResource(gridViewImageId[position]);
        return gridViewAndroid;
    }
}
