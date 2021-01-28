/** Anthony Weiss (atw73) and Michael Trinh (mht46) */

package com.example.museum;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputFilter;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {


    /** Assigning the main image button */
    ImageButton activityButtontwo;
    TextView activityTwoText;
    Toast toast;

    // Textboxes for ticket prices
    TextView adultText;
    TextView seniorText;
    TextView studentText;

    // Input text boxes
    Spinner adultTicketInput;
    Spinner seniorTicketInput;
    Spinner studentTicketInput;

    TextView ticketPrice;
    TextView salesTax;
    TextView totalPrice;

    int adultTicket;
    int seniorTicket;
    int studentTicket;
    double tax;
    Integer[] ticketNum = new Integer[]{0,1,2,3,4,5};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
      


        /** Finding id's of items*/
        activityButtontwo = findViewById(R.id.activityButtonTwo);
        activityTwoText = findViewById(R.id.activityTwoText);
        adultText = findViewById(R.id.adultText);
        seniorText = findViewById(R.id.seniorText);
        studentText = findViewById(R.id.studentText);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item,ticketNum);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                int basePrice = calculateTicketPrice();
                double taxCost = basePrice * tax;
                String price = "$";
                price += calculateTicketPrice();
                ticketPrice.setText(price);

                salesTax.setText(String.format("$%,.2f",taxCost));
                totalPrice.setText(String.format("$%,.2f",basePrice + taxCost));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        };

        adultTicketInput = findViewById(R.id.adultTicketInput);
        adultTicketInput.setAdapter(adapter);
        adultTicketInput.setOnItemSelectedListener(listener);

        seniorTicketInput = findViewById(R.id.seniorTicketInput);
        seniorTicketInput.setAdapter(adapter);
        seniorTicketInput.setOnItemSelectedListener(listener);

        studentTicketInput = findViewById(R.id.studentTicketInput);
        studentTicketInput.setAdapter(adapter);
        studentTicketInput.setOnItemSelectedListener(listener);

        ticketPrice = findViewById(R.id.ticketPrice);
        salesTax = findViewById(R.id.salesTax);
        totalPrice = findViewById(R.id.totalPrice);

        adultTicket = getIntent().getIntExtra("adultTicket", 0);
        seniorTicket = getIntent().getIntExtra("seniorTicket", 0);
        studentTicket = getIntent().getIntExtra("studentTicket", 0);
        tax = getIntent().getDoubleExtra("salesTax",0.0);

        /** Setting the bundle to get MainActivity's intents for setting text and image*/
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            int resId = bundle.getInt("resId");
            activityButtontwo.setImageResource(resId);
            activityTwoText.setText(getIntent().getStringExtra("resId2"));
            adultText.setText(getIntent().getStringExtra("adultPrice"));
            seniorText.setText(getIntent().getStringExtra("seniorPrice"));
            studentText.setText(getIntent().getStringExtra("studentPrice"));
        }

        /** Displays the "Toast" message that notifies user of maximum allowed tickets*/
        toast = Toast.makeText(getApplicationContext(), "Maximum of 5 tickets for each!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,50);
        toast.show();


        /** Listener for the image button, which  checks the activity's textfield for the Museum name, and passes along the
         * according website to the openMuseumWebsite method */
        activityButtontwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View MainActivity2){
                if(activityTwoText.getText().toString().equals("Museum of Modern Art")) {
                    openMuseumWebsite("https://www.moma.org/");
                }
                else if(activityTwoText.getText().toString().equals("Museum of Natural History")){
                    openMuseumWebsite("https://www.amnh.org/");
                }
                else if(activityTwoText.getText().toString().equals("New Museum of Contemporary Art")){
                    openMuseumWebsite("https://www.newmuseum.org/");
                }
                else if(activityTwoText.getText().toString().equals("Metropolitan Museum")){
                    openMuseumWebsite("https://www.metmuseum.org/");
                }
            }
        });
    }

    /** Method for opening website's url*/
    public void openMuseumWebsite(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public int calculateTicketPrice(){

        int ticketPriceAdult = Integer.parseInt(adultTicketInput.getSelectedItem().toString());
        int ticketPriceSenior = Integer.parseInt(seniorTicketInput.getSelectedItem().toString());
        int ticketPriceStudent = Integer.parseInt(studentTicketInput.getSelectedItem().toString());
        int ticketPrice = 0;

        ticketPrice = ticketPriceAdult*adultTicket + ticketPriceSenior*seniorTicket +
                ticketPriceStudent*studentTicket;

        return ticketPrice;
    }


    /** Method when Back Button is pressed*/
    public boolean onBackButtonPressed(MenuItem item){
        Intent goBack = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(goBack, 0);
        return true;
    }



}