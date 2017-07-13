package com.androidapps.avinashtadavarthy.booktheshow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewFood extends ArrayAdapter<FoodItem> {

    private List<FoodItem> food_items;
    private int layoutResourceId;
    private Context context;

    public ListViewFood(Context context, int layoutResourceId, ArrayList<FoodItem> food_items){
        super(context, layoutResourceId, food_items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.food_items = food_items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final FoodItemHolder holder = new FoodItemHolder();

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder.foodItem = food_items.get(position);
        holder.food_image = (ImageView) row.findViewById(R.id.food);
        holder.food_image.setTag(holder.foodItem);

        holder.food_name = (TextView)row.findViewById(R.id.food_name);
        holder.food_price = (TextView)row.findViewById(R.id.food_price);
        holder.food_quantity = (TextView)row.findViewById(R.id.food_quantity);

        row.setTag(holder);
        setupItem(holder);
        return row;
    }

    private void setupItem(FoodItemHolder holder) {
        holder.food_name.setText(holder.foodItem.getName());
        holder.food_price.setText(String.valueOf(holder.foodItem.getPrice()));
        holder.food_quantity.setText(String.valueOf(holder.foodItem.getQuantity()));
        holder.food_image.setImageResource(holder.foodItem.getFoodID());
    }

    public static class FoodItemHolder {
        FoodItem foodItem;
        TextView food_name,food_price,food_quantity;
        ImageView food_image;
    }


}



