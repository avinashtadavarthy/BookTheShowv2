package com.androidapps.avinashtadavarthy.booktheshow;

import android.content.Intent;
import android.graphics.Movie;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.androidapps.avinashtadavarthy.booktheshow.R.id.film_image;
import static com.androidapps.avinashtadavarthy.booktheshow.R.id.spinner;
import static com.androidapps.avinashtadavarthy.booktheshow.R.id.wrap_content;

public class MovieDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView film_name,film_cert,film_synopsis,film_genre,film_cast,film_runtime;
    ImageView film_image;
    Spinner spin_tickets,spin_days,spin_months;

    GridView showTimeGridView;
    int lastExpandedPosition = -1;

    Intent movetoSeats;

    final String[] show_name = {
            "MORNING", "MATINEE", "EVENING", "NIGHT"
    } ;

    final String[] show_time = {
            "10:30 am", "3:00 pm", "7:00 pm", "9:30 pm"
    };

    final String[] tickets = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    final String[] days = new String[] {"1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    final String[] months = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


    // For the Expandable ListView

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_details);

        movetoSeats = new Intent(MovieDetails.this,SelectSeats.class);

        film_name = (TextView) findViewById(R.id.film_name);
        film_cert = (TextView) findViewById(R.id.film_cert);
        film_synopsis = (TextView) findViewById(R.id.film_synopsis);
        film_genre = (TextView) findViewById(R.id.film_genre);
        film_cast = (TextView) findViewById(R.id.film_cast);
        film_runtime = (TextView) findViewById(R.id.film_runtime);
        film_image = (ImageView) findViewById(R.id.film_image);

        final String name = getIntent().getStringExtra("film_name");
        film_name.setText(name);

        final String cert = getIntent().getStringExtra("film_cert");
        film_cert.setText(cert);

        switch(name){
            case "Bahubali 2" :
                //Picasso.with(this).load("http://images.indianexpress.com/2017/01/baahubali-2-759.jpg").resize(x,y).centerCrop().into(film_image);
                film_image.setImageResource(R.drawable.bahu);
                film_synopsis.setText("Shiva, the son of Bahubali, begins to search for answers after he learns about his heritage and the events that unfolded in the Mahishmati Kingdom.");
                film_genre.setText("Action, Drama, History, War");
                film_cast.setText("Anushka Shetty, Prabhas, Rana Daggubati, Tamanna Bhatia");
                film_runtime.setText("168 Minutes");
                break;

            case "Boss Baby" :
                film_image.setImageResource(R.drawable.boss);
                film_synopsis.setText("A suit-wearing briefcase-carrying baby pairs up with his seven-year-old brother to stop the dastardly plot of the CEO of Puppy Co.");
                film_genre.setText("Animation, Comedy, Family");
                film_cast.setText("Alec Baldwin, Steve Buscemi, Tobey Maguire");
                film_runtime.setText("98 Minutes");
                break;

            case "Baby Driver" :
                film_image.setImageResource(R.drawable.baby);
                film_synopsis.setText("Talented getaway driver relies on the beat of his personal soundtrack to be the best in the game. But after being coerced into working for a crime boss, he must face the music when a doomed heist threatens his life, love, and freedom.");
                film_genre.setText("Action, Crime, Musical");
                film_cast.setText("Ansel Elgort, Jamie Foxx, Jon Hamm, Kevin Spacey, Lily James");
                film_runtime.setText("115 Minutes");
                break;

            case "The Big Sick" :
                film_image.setImageResource(R.drawable.theb);
                film_synopsis.setText("Pakistan-born comedian and cab driver Kumail Nanjiani is instantly attracted towards American student Emily Gordon whom he meets at a bar and develops a romantic relationship with.");
                film_genre.setText("Comedy, Romance");
                film_cast.setText("Holly Hunter, Kumail Nanjiani, Ray Romano, Zoe Kazan");
                film_runtime.setText("122 Minutes");
                break;

            case "Cars 3" :
                film_image.setImageResource(R.drawable.cars);
                film_synopsis.setText("The famous Lightning McQueen must prove to a new generation of high tech racer's that he's still the best car in the world.");
                film_genre.setText("Adventure, Animation, Comedy, Sports");
                film_cast.setText("Armie Hammer, Cristela Alonzo, Owen Wilson");
                film_runtime.setText("102 Minutes");
                break;

            case "DJ" :
                film_image.setImageResource(R.drawable.duvv);
                film_synopsis.setText("A righteous young man who helps everyone gain their rightful justice, gets recruited as an undercover agent to work on a high profile case that involves a crime lord working for a corrupt minister.");
                film_genre.setText("Action, Comedy");
                film_cast.setText("Allu Arjun, Pooja Hegde");
                film_runtime.setText("156 Minutes");
                break;

            case "Despicable Me 3" :
                film_image.setImageResource(R.drawable.desp);
                film_synopsis.setText("Gru must face off with a formal child star, Balthazar Bratt who happens to be obsessed with the character that he played in the '80s");
                film_genre.setText("Adventure, Animation, Comedy");
                film_cast.setText("Kristen Wiig, Pierre Coffin, Steve Carell, Trey Parker");
                film_runtime.setText("89 Minutes");
                break;

            case "Guest iin London" :
                //Picasso.with(this).load("https://scontent.fmaa2-1.fna.fbcdn.net/v/t1.0-9/16806800_1283672948384558_8857643183221490467_n.jpg?oh=b1e5bd7d2caf6bc6b95ffb660e83f14b&oe=59C31CA1").resize(360,80).centerCrop().into(film_image);
                film_image.setImageResource(R.drawable.gues);
                film_synopsis.setText("A young couple in London who are in a live-in relationship, struggle to co-exist with their bothersome guests who seem to overstay their welcome.");
                film_genre.setText("Comedy, Drama");
                film_cast.setText("Kartik Aryan Tiwari, Kriti Kharbanda, Paresh Rawal, Tanvi Azmi");
                film_runtime.setText("138 Minutes");
                break;

            case "Hindi Medium" :
                film_image.setImageResource(R.drawable.hind);
                film_synopsis.setText("A couple from Chandni Chowk aspire to provide their daughter with the best education, as they try to fit-in and get accepted into the elite social groups of Delhi.");
                film_genre.setText("Comedy, Drama");
                film_cast.setText("Irrfan Khan, Saba Qamar");
                film_runtime.setText("133 Minutes");
                break;

            case "Ivan Thanthiran" :
                film_image.setImageResource(R.drawable.ivan);
                film_synopsis.setText("Two engineering dropouts decide to expose the illegal activities of a corrupt education minister who launches a manhunt search to destroy their plans.");
                film_genre.setText("Action, Romance");
                film_cast.setText("Gautham Karthik, Shraddha Srinath");
                film_runtime.setText("121 Minutes");
                break;

            case "MOM" :
                film_image.setImageResource(R.drawable.momm);
                film_synopsis.setText("A thriller film directed by Ravi Udywar, starring Sridevi Kapoor, Akshaye Khanna and Sajal Ali in the lead roles.");
                film_genre.setText("Drama, Thriller");
                film_cast.setText("Akshaye Khanna, Sajal Ali, Sridevi Kapoor");
                film_runtime.setText("147 Minutes");
                break;

            case "Spiderman Homecoming" :
                film_image.setImageResource(R.drawable.spid);
                film_synopsis.setText("Post the events of Captain America: Civil War, Peter Parker utilizes the help of his mentor Tony Stark to maintain a balance between his normal life as a high school student and his real job of fighting crime.");
                film_genre.setText("Action, Adventure, Fantasy, Sci-Fi");
                film_cast.setText("Marisa Tomei, Michael Keaton, Robert Downey Jr, Tom Holland, Zendaya");
                film_runtime.setText("134 Minutes");
                break;

            case "Tubelight" :
                film_image.setImageResource(R.drawable.tube);
                film_synopsis.setText("A gullible and kind Laxman Singh Bisht who has a reputation of being a 'Tubelight', preserves his unshakable faith and optimism of protecting his family, as he embarks on an enthralling journey");
                film_genre.setText("Drama, Romance, War");
                film_cast.setText("Salman Khan, Sohail Khan, Zhu Zhu");
                film_runtime.setText("136 Minutes");
                break;

            case "Vanamagan" :
                film_image.setImageResource(R.drawable.vana);
                film_synopsis.setText("A tribal man who escapes from the captivity of the men hunting his people, finds himself in the care and protection of a rich girl who ends up falling in love with him.");
                film_genre.setText("Action, Adventure");
                film_cast.setText("Jayam Ravi, Sayyeshaa Saigal");
                film_runtime.setText("140 Minutes");
                break;

            case "Wonder Woman" :
                film_image.setImageResource(R.drawable.wond);
                film_synopsis.setText("Amazonian warrior princess, Diana Prince, discovers her real potential and finds her true destiny of protecting the island of Themyscira and all of humankind.");
                film_genre.setText("Action, Adventure, Fantasy, Sci-Fi");
                film_cast.setText("Chris Pine, Danny Huston, David Thewlis, Gal Gadot, Robin Wright");
                film_runtime.setText("143 Minutes");
                break;
        }

        spin_tickets = (Spinner) findViewById(R.id.spin_tickets);
        spin_days = (Spinner) findViewById(R.id.spin_days);
        spin_months = (Spinner) findViewById(R.id.spin_months);

        spin_tickets.setOnItemSelectedListener(this);
        spin_days.setOnItemSelectedListener(this);
        spin_months.setOnItemSelectedListener(this);

        ArrayAdapter<String> ticketAdapter = new ArrayAdapter <String>(this,R.layout.spinner_dropdown, tickets);
        ArrayAdapter<String> dayAdapter = new ArrayAdapter <String>(this,R.layout.spinner_dropdown, days);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter <String>(this,R.layout.spinner_dropdown, months);

        spin_tickets.setAdapter(ticketAdapter);
        spin_days.setAdapter(dayAdapter);
        spin_months.setAdapter(monthAdapter);

        /*
        // For the gridview
        ShowTimeGrid adapter = new ShowTimeGrid(MovieDetails.this, show_name, show_time);
        showTimeGridView=(GridView)findViewById(R.id.grid_show_times);
        showTimeGridView.setAdapter(adapter);
        showTimeGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                movetoSeats.putExtra("show_name", show_name[i])
                        .putExtra("show_time", show_time[i])
                        .putExtra("film_name",name)
                        .putExtra("film_cert",cert);

                startActivity(movetoSeats);
                overridePendingTransition(R.anim.right_enter, R.anim.left_out);
            }
        }); */

        //For Expandable ListView
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        prepareListData();
        listAdapter = new ExpandableListAdapter(MovieDetails.this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        MovieDetails.this, listDataChild.get(
                                listDataHeader.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT)
                        .show();
                return true;
            }
        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                movetoSeats.putExtra("theatre",listDataHeader.get(groupPosition));
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Sathyam");
        listDataHeader.add("Escape");
        listDataHeader.add("Palazzo");
        listDataHeader.add("PVR");
        listDataHeader.add("Inox");

        // Adding child data
        List<String> Sathyam = new ArrayList<String>();
        Sathyam.add("MORNING - 10:30 am");
        Sathyam.add("MATINEE - 3:00 pm");
        Sathyam.add("EVENING - 7:00 pm");
        Sathyam.add("NIGHT - 9:30 pm");

        List<String> Escape = new ArrayList<String>();
        Escape.add("MORNING - 10:30 am");
        Escape.add("MATINEE - 3:00 pm");
        Escape.add("EVENING - 7:00 pm");
        Escape.add("NIGHT - 9:30 pm");

        List<String> Palazzo = new ArrayList<String>();
        Palazzo.add("MORNING - 10:30 am");
        Palazzo.add("MATINEE - 3:00 pm");
        Palazzo.add("EVENING - 7:00 pm");
        Palazzo.add("NIGHT - 9:30 pm");

        List<String> PVR = new ArrayList<String>();
        PVR.add("MORNING - 10:30 am");
        PVR.add("MATINEE - 3:00 pm");
        PVR.add("EVENING - 7:00 pm");
        PVR.add("NIGHT - 9:30 pm");

        List<String> Inox = new ArrayList<String>();
        Inox.add("MORNING - 10:30 am");
        Inox.add("MATINEE - 3:00 pm");
        Inox.add("EVENING - 7:00 pm");
        Inox.add("NIGHT - 9:30 pm");

        listDataChild.put(listDataHeader.get(0), Sathyam);
        listDataChild.put(listDataHeader.get(1), Escape);
        listDataChild.put(listDataHeader.get(2), Palazzo);
        listDataChild.put(listDataHeader.get(3), PVR);
        listDataChild.put(listDataHeader.get(4), Inox);
    }

    
    @Override
    public void onBackPressed()
    {
        this.finish();
        overridePendingTransition(R.anim.right_out, R.anim.left_enter);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){

            case R.id.spin_tickets: movetoSeats.putExtra("ticket", tickets[position]); break;
            case R.id.spin_months: movetoSeats.putExtra("month", months[position]); break;
            case R.id.spin_days: movetoSeats.putExtra("day", days[position]); break;

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}