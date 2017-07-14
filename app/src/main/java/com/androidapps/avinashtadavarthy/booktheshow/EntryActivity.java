package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.os.DropBoxManager;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.dd.CircularProgressButton;

public class EntryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    CircularProgressButton circularProgressButton;
    Spinner spinner;
    TextView errorMessage;
    EditText editName;

    Intent movetoSelectCinema;
    final String[] SPINNER_DATA = new String[] {"Chennai", "Delhi", "Hyderabad", "Mumbai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_entry);

        circularProgressButton =(CircularProgressButton) findViewById(R.id.btnLogin);
        circularProgressButton.setIndeterminateProgressMode(true);

        spinner = (Spinner) findViewById(R.id.spinner);
        errorMessage = (TextView) findViewById(R.id.errorMessage);
        editName = (EditText) findViewById(R.id.editName);

        errorMessage.setText(null);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_dropdown, SPINNER_DATA);
        spinner.setAdapter(adapter);

        movetoSelectCinema = new Intent(EntryActivity.this, SelectCinema.class);

        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!editName.getText().toString().equals("")) {
                    circularProgressButton.setProgress(50);

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            movetoSelectCinema.putExtra("name", editName.getText().toString());
                            startActivity(movetoSelectCinema);
                            overridePendingTransition(R.anim.right_enter, R.anim.left_out);
                        }
                    }, 2000);

                }
                else
                {
                    circularProgressButton.setProgress(0);
                    errorMessage.setText("Please fill in the necessary details!");
                }

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    protected void onStart() {
        super.onStart();

        circularProgressButton.setProgress(0);
        errorMessage.setText("");
        editName.setText("");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
