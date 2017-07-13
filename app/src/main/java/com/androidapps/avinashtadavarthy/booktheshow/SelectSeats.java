package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SelectSeats extends AppCompatActivity {

    TextView number_of_tickets, movie_ka_naam, movie_certif, movie_ka_day, movie_ka_month, movie_ka_time, movie_ka_showtype, notation, price;

    String showTicket;
    int ticket_counter;

    GridSelectSeats adapter = new GridSelectSeats(SelectSeats.this,48);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_seats);

        ActionBar bar = getSupportActionBar();
        
        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        bar.setDisplayShowCustomEnabled(true);
        bar.setCustomView(R.layout.action_bar_seats);

        final String showName = getIntent().getStringExtra("show_name");
        final String showTime = getIntent().getStringExtra("show_time");
        showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");

        number_of_tickets = (TextView) bar.getCustomView().findViewById(R.id.number_of_tickets);
        number_of_tickets.setText(showTicket);
        movie_ka_naam = (TextView) bar.getCustomView().findViewById(R.id.movie_ka_naam);
        movie_ka_naam.setText(movieName);
        movie_certif = (TextView) bar.getCustomView().findViewById(R.id.movie_certif);
        movie_certif.setText(movieCertif);
        movie_ka_day = (TextView) bar.getCustomView().findViewById(R.id.movie_ka_day);
        movie_ka_day.setText(showDay);
        movie_ka_month = (TextView) bar.getCustomView().findViewById(R.id.movie_ka_month);
        movie_ka_month.setText(showMonth);
        movie_ka_time = (TextView) bar.getCustomView().findViewById(R.id.movie_ka_time);
        movie_ka_time.setText(showTime);
        movie_ka_showtype = (TextView) bar.getCustomView().findViewById(R.id.movie_ka_showtype);
        movie_ka_showtype.setText(showName);
        notation = (TextView) bar.getCustomView().findViewById(R.id.notation);
        switch(showDay){
            case "1": notation.setText("st"); break;
            case "2": notation.setText("nd"); break;
            case "3": notation.setText("rd"); break;
            default: notation.setText("th"); break;
        }
        price = (TextView) bar.getCustomView().findViewById(R.id.price);
        final int cost = Integer.parseInt(showTicket)*120;
        price.setText(Integer.toString(Integer.parseInt(showTicket)*120));

        final GridView grid_select_seats_1 = (GridView) findViewById(R.id.grid_select_seats_1);
        grid_select_seats_1.setAdapter(adapter);
        final GridView grid_select_seats_2 = (GridView) findViewById(R.id.grid_select_seats_2);
        grid_select_seats_2.setAdapter(adapter);

        ticket_counter = Integer.parseInt(showTicket);

                    if(ticket_counter!=0){
                        grid_select_seats_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                ImageView seat = (ImageView) view.findViewById(R.id.seat);
                                if(seat.getDrawable().getConstantState().equals
                                        (getResources().getDrawable(R.drawable.seat).getConstantState())){
                                    seat.setImageResource(R.drawable.seat_selected);
                                    ticket_counter--;
                                    number_of_tickets.setText(Integer.toString(ticket_counter));
                                } else{
                                    seat.setImageResource(R.drawable.seat);
                                    ticket_counter++;
                                    number_of_tickets.setText(Integer.toString(ticket_counter));
                                }

                                if(ticket_counter == 0){
                                    showToastMessage("No more seats to select", 1000);

                                    Intent movetoFood = new Intent(SelectSeats.this,SelectFood.class)
                                            .putExtra("price",cost)
                                            .putExtra("show_time", showTime)
                                            .putExtra("film_name",movieName)
                                            .putExtra("film_cert",movieCertif)
                                            .putExtra("ticket",showTicket)
                                            .putExtra("month",showMonth)
                                            .putExtra("day",showDay)
                                            .putExtra("show_name",showName);

                                    startActivity(movetoFood);
                                    overridePendingTransition(R.anim.right_enter, R.anim.left_out);

                                }
                            }
                        });

                        grid_select_seats_2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                ImageView seat = (ImageView) view.findViewById(R.id.seat);
                                if(seat.getDrawable().getConstantState().equals
                                        (getResources().getDrawable(R.drawable.seat).getConstantState())){
                                    seat.setImageResource(R.drawable.seat_selected);
                                    ticket_counter--;
                                    number_of_tickets.setText(Integer.toString(ticket_counter));
                                } else{
                                    seat.setImageResource(R.drawable.seat);
                                    ticket_counter++;
                                    number_of_tickets.setText(Integer.toString(ticket_counter));
                                }

                                if(ticket_counter == 0){
                                    showToastMessage("No more seats to select", 1000);

                                    Intent movetoFood = new Intent(SelectSeats.this,SelectFood.class)
                                            .putExtra("price",cost)
                                            .putExtra("show_time", showTime)
                                            .putExtra("film_name",movieName)
                                            .putExtra("film_cert",movieCertif)
                                            .putExtra("ticket",showTicket)
                                            .putExtra("month",showMonth)
                                            .putExtra("day",showDay)
                                            .putExtra("show_name",showName);

                                    startActivity(movetoFood);
                                    overridePendingTransition(R.anim.right_enter, R.anim.left_out);

                                }
                            }
                        });
                    }



        Button btnContinue = (Button) findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoFood = new Intent(SelectSeats.this,SelectFood.class)
                        .putExtra("price",cost)
                        .putExtra("show_time", showTime)
                        .putExtra("film_name",movieName)
                        .putExtra("film_cert",movieCertif)
                        .putExtra("ticket",showTicket)
                        .putExtra("month",showMonth)
                        .putExtra("day",showDay)
                        .putExtra("show_name",showName);

                startActivity(movetoFood);
                showToastMessage("Seats have been chosen by the system",1500);

                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

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

    @Override
    public void onBackPressed()
    {
        this.finish();
        overridePendingTransition(R.anim.right_out, R.anim.left_enter);
    }


}
