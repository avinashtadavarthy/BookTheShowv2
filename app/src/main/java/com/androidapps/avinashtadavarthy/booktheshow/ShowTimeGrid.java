package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Avinash Tadavarthy on 10-Jul-17.
 */

public class ShowTimeGrid extends BaseAdapter {

    private Context mContext;
    private final String[] show_name;
    private final String[] show_time;

    public ShowTimeGrid(Context context, String[] show_name, String[] show_time) {
        mContext = context;
        this.show_name = show_name;
        this.show_time = show_time;
    }

    @Override
    public int getCount() {
        return show_name.length;
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
            gridViewAndroid = inflater.inflate(R.layout.show_time_grid,null);

        } else {
            gridViewAndroid = (View) convertView;
        }

        TextView get_show_name = (TextView) gridViewAndroid.findViewById(R.id.show_name);
        TextView get_show_time = (TextView) gridViewAndroid.findViewById(R.id.show_time);
        get_show_name.setText(show_name[position]);
        get_show_time.setText(show_time[position]);

        return gridViewAndroid;
    }
}
