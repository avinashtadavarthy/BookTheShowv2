package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class SelectCinema extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    GridView androidGridView;

    String[] gridViewString = {
            "Bahubali 2", "Boss Baby", "Baby Driver",
            "The Big Sick", "Cars 3", "DJ",
            "Despicable Me 3", "Guest iin London", "Hindi Medium",
            "Ivan Thanthiran", "MOM", "Spiderman Homecoming",
            "Tubelight", "Vanamagan", "Wonder Woman"
    } ;
    
    String[] certString = {
            "U", "U", "U/A",
            "A", "U", "U/A",
            "U", "U", "U/A",
            "U", "A", "U",
            "U", "U", "U"
    };

    int[] gridViewImageId = {
            R.drawable.b2, R.drawable.bb, R.drawable.bd,
            R.drawable.bs, R.drawable.c3, R.drawable.dj,
            R.drawable.dm3, R.drawable.gil, R.drawable.hm,
            R.drawable.it, R.drawable.mom, R.drawable.sh,
            R.drawable.tl, R.drawable.vm, R.drawable.ww

    };

    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cinema);

        userName = (TextView) findViewById(R.id.userName);

        String name = getIntent().getStringExtra("name");
        userName.setText(name.toUpperCase());

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // For the view flipper
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(this, R.anim.right_enter);
        viewFlipper.setOutAnimation(this, R.anim.left_out);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();

        ImageView baahubali2 = (ImageView) findViewById(R.id.baahubali2);
        baahubali2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class).putExtra("film_name","Bahubali 2").putExtra("film_cert", "U") ;
                startActivity(movetoDetails);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        ImageView despicableme3 = (ImageView) findViewById(R.id.despicableme3);
        despicableme3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class).putExtra("film_name","Despicable Me 3").putExtra("film_cert", "U") ;
                startActivity(movetoDetails);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        ImageView spiderman = (ImageView) findViewById(R.id.spiderman);
        spiderman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class).putExtra("film_name","Spiderman Homecoming").putExtra("film_cert", "U") ;
                startActivity(movetoDetails);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        ImageView tubelight = (ImageView) findViewById(R.id.tubelight);
        tubelight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class).putExtra("film_name","Tubelight").putExtra("film_cert", "U") ;
                startActivity(movetoDetails);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        ImageView wonderwoman = (ImageView) findViewById(R.id.wonderwoman);
        wonderwoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class).putExtra("film_name","Wonder Woman").putExtra("film_cert", "U") ;
                startActivity(movetoDetails);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

        // For the gridview
        CustomGridViewActivity adapter = new CustomGridViewActivity(SelectCinema.this, gridViewString, certString, gridViewImageId);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapter);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent movetoDetails = new Intent(SelectCinema.this, MovieDetails.class)
                        .putExtra("film_name", gridViewString[i])
                        .putExtra("film_cert", certString[i]);
                startActivity(movetoDetails);
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

}

