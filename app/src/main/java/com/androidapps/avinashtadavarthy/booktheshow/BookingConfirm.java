package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BookingConfirm extends AppCompatActivity {

    TextView conf_movie,conf_certif,conf_theatre,conf_tickets,conf_details,conf_bookid;
    ImageView conf_image;

    Button explore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_confirm);

        final String showTime = getIntent().getStringExtra("show_time");
        final String showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");
        final String showTheatre = getIntent().getStringExtra("theatre");
        final String ticketcost = getIntent().getStringExtra("ticketcost");

        conf_movie = (TextView) findViewById(R.id.conf_movie);
        conf_movie.setText(movieName);
        conf_certif = (TextView) findViewById(R.id.conf_certif);
        conf_certif.setText(movieCertif);
        conf_theatre = (TextView) findViewById(R.id.conf_theatre);
        conf_theatre.setText(showTheatre + " | " + showTime);
        conf_details = (TextView) findViewById(R.id.conf_details);
        conf_details.setText("Date: " + showDay + " " + showMonth + " 2017");
        conf_tickets = (TextView) findViewById(R.id.conf_tickets);
        conf_tickets.setText(showTicket + " Tickets at ₹" + ticketcost);

        conf_bookid = (TextView) findViewById(R.id.conf_bookid);

        conf_image = (ImageView) findViewById(R.id.conf_image);

        switch(movieName){
            case "Bahubali 2" :
                conf_image.setImageResource(R.drawable.bahu);
                break;

            case "Boss Baby" :
                conf_image.setImageResource(R.drawable.boss);
                break;

            case "Baby Driver" :
                conf_image.setImageResource(R.drawable.baby);
               break;

            case "The Big Sick" :
                conf_image.setImageResource(R.drawable.theb);
                break;

            case "Cars 3" :
                conf_image.setImageResource(R.drawable.cars);
                break;

            case "DJ" :
                conf_image.setImageResource(R.drawable.duvv);
                break;

            case "Despicable Me 3" :
                conf_image.setImageResource(R.drawable.desp);
                break;

            case "Guest iin London" :
                conf_image.setImageResource(R.drawable.gues);
                break;

            case "Hindi Medium" :
                conf_image.setImageResource(R.drawable.hind);
                break;

            case "Ivan Thanthiran" :
                conf_image.setImageResource(R.drawable.ivan);
                break;

            case "MOM" :
                conf_image.setImageResource(R.drawable.momm);
                break;

            case "Spiderman Homecoming" :
                conf_image.setImageResource(R.drawable.spid);
                break;

            case "Tubelight" :
                conf_image.setImageResource(R.drawable.tube);
                break;

            case "Vanamagan" :
                conf_image.setImageResource(R.drawable.vana);
                break;

            case "Wonder Woman" :
                conf_image.setImageResource(R.drawable.wond);
                break;
        }

        explore = (Button) findViewById(R.id.explore);

        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoEntry = new Intent(BookingConfirm.this,EntryActivity.class);
                startActivity(movetoEntry);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

    }

}



