package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectPayment extends AppCompatActivity {

    EditText final_card, final_nameoncard, final_mm, final_yyyy, final_cvv;
    ImageView visa, mastercard;
    TextView error;
    Button btnPay;

    String ticketcost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_payment);

        final String showTime = getIntent().getStringExtra("show_time");
        final String showTicket = getIntent().getStringExtra("ticket");
        final String showMonth = getIntent().getStringExtra("month");
        final String showDay = getIntent().getStringExtra("day");
        final String movieName = getIntent().getStringExtra("film_name");
        final String movieCertif = getIntent().getStringExtra("film_cert");
        final String showTheatre = getIntent().getStringExtra("theatre");


        final_card = (EditText) findViewById(R.id.final_card);
        final_nameoncard = (EditText) findViewById(R.id.final_nameoncard);
        final_mm = (EditText) findViewById(R.id.final_mm);
        final_yyyy = (EditText) findViewById(R.id.final_yyyy);
        final_cvv = (EditText) findViewById(R.id.final_cvv);

        visa = (ImageView) findViewById(R.id.visa);
        mastercard = (ImageView) findViewById(R.id.mastercard);
        error = (TextView) findViewById(R.id.error);

        ticketcost = getIntent().getStringExtra("ticketcost");
        TextView final_price = (TextView) findViewById(R.id.final_price);
        final_price.setText(ticketcost);

        final_card.addTextChangedListener(new TextWatcher() {
            int count = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!final_card.getText().toString().equals("")){

                    mastercard.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                    visa.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                    error.setText("");

                    switch(final_card.getText().toString().substring(0, 1)){
                        case "4": visa.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.spinner_border));
                            mastercard.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                            error.setText("");
                                    break;
                        case "5": mastercard.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.spinner_border));
                            visa.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                            error.setText("");
                            break;
                        default: mastercard.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                            visa.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.color.transparent));
                            error.setText("Only Visa or MasterCard"); break;
                    }
                }

               if(final_card.getText().toString().length() != 19  || final_card.getText().toString() == ""){
                   final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke_red));
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (count <= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString()+" ");
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }else if (count >= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString().substring(0,final_card.getText().toString().length()-1));
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }
                count = final_card.getText().toString().length();

                 if(final_card.getText().toString().length() != 19 || final_card.getText().toString() == "")
                    final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke_red));
                else
                    final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke));

            }
        });

        btnPay = (Button) findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movetoBooking = new Intent(SelectPayment.this,BookingConfirm.class)
                        .putExtra("show_time", showTime)
                        .putExtra("film_name",movieName)
                        .putExtra("film_cert",movieCertif)
                        .putExtra("ticket",showTicket)
                        .putExtra("month",showMonth)
                        .putExtra("day",showDay)
                        .putExtra("theatre",showTheatre)
                        .putExtra("ticketcost",Integer.toString(Integer.parseInt(showTicket)*120));

                startActivity(movetoBooking);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        });

    }
}
