package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SelectFood extends AppCompatActivity {

    ArrayList<FoodItem> foodItems;
    TextView total_price;

    Intent movetoPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_food);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_food);

        foodItems = new ArrayList<FoodItem>();
        total_price = (TextView) findViewById(R.id.total_price);

        final String showTime = getIntent().getStringExtra("show_time");
        final String showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");
        final String price = getIntent().getStringExtra("price");

        total_price.setText(Integer.toString(Integer.parseInt(showTicket)*120));

        foodItems.add(new FoodItem(R.drawable.popcorn, "popcorn", 100, 0));
        foodItems.add(new FoodItem(R.drawable.caramel, "caramel popcorn", 110, 0));
        foodItems.add(new FoodItem(R.drawable.coke, "coke", 90, 0));
        foodItems.add(new FoodItem(R.drawable.hotdog, "hotdog", 90, 0));
        foodItems.add(new FoodItem(R.drawable.nachos, "nachos", 140, 0));
        foodItems.add(new FoodItem(R.drawable.puff, "puff", 70, 0));
        foodItems.add(new FoodItem(R.drawable.water, "water", 30, 0));


        ListViewFood adapter = new ListViewFood(SelectFood.this, R.layout.list_view_layout, foodItems);
        final ListView listViewFood = (ListView)findViewById(R.id.listViewFood);
        listViewFood.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movetoPayment = new Intent(SelectFood.this,SelectPayment.class);
                startActivity(movetoPayment);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        this.finish();
        overridePendingTransition(R.anim.right_out, R.anim.left_enter);
    }

    public void showToastMessage(String text, int duration){
        final Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }

}
