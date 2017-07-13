package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Avinash Tadavarthy on 11-Jul-17.
 */

public class GridSelectSeats extends BaseAdapter {
    private Context mContext;
    private int number_of_seats;

    public GridSelectSeats(Context context, int number_of_seats) {
        mContext = context;
        this.number_of_seats = number_of_seats;
    }

    @Override
    public int getCount() {
        return number_of_seats;
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
            gridViewAndroid = inflater.inflate(R.layout.grid_select_seats_layout,null);

        } else {
            gridViewAndroid = (View) convertView;
        }

        ImageView seat = (ImageView) gridViewAndroid.findViewById(R.id.seat);
        seat.setImageResource(R.drawable.seat);
        return gridViewAndroid;

    }
}
