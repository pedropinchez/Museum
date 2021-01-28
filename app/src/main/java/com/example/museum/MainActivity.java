/** Anthony Weiss (atw73) and Michael Trinh (mht46) */

package com.example.museum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    /** Assigning variable names to ImageButtons */
    ImageButton modernArtButton;
    ImageButton naturalHistoryButton;
    ImageButton contemporaryArtButton;
    ImageButton metropolitanButton;

    /** used for sending museum name from activity 1 to activity 2 */
    int ticketPriceAdult;
    int ticketPriceSenior;
    int ticketPriceStudent;
    double salesTax;
    double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Assigns button as variables */
        modernArtButton = findViewById(R.id.museumOfModernArt);
        naturalHistoryButton = findViewById(R.id.naturalHistoryMuseumButton);
        contemporaryArtButton = findViewById(R.id.contemporaryMuseumButton);
        metropolitanButton = findViewById(R.id.MetropolitanMuseumButton);

        /** Listener for Modern Art button */
        modernArtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View MainActivity2){
                sendImageModernArt(MainActivity2);
            }
        });

        /** Listener for Natural History center button */
        naturalHistoryButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View MainActivity2){
                sendImageNaturalHistory(MainActivity2);
            }
        });

        /** Listener for Contemporary Art button */
        contemporaryArtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View MainActivity2){
                sendImageContemporaryArt(MainActivity2);
            }
        });

        /** Listener for Metropolitan button */
        metropolitanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View MainActivity2){
                sendImageMetropolitan(MainActivity2);
            }
        });

    }


    /** method for sending Modern Art Museum image + text when Modern Art button is clicked */
    public void sendImageModernArt(View view){
        EditText editText = findViewById(R.id.textModernArtMuseum);
        String text = editText.getText().toString();

        /** Setting the strings to pass along to activity 2*/
        String adultPrice = "Adults: $25";
        String seniorPrice = "Seniors: $18";
        String studentPrice = "Students: $14";

        /** ticket prices to pass along to activity 2 for calculation*/
        ticketPriceAdult = 25;
        ticketPriceSenior = 18;
        ticketPriceStudent = 14;
        salesTax = 0.08875;
        Intent sendImageIntent = new Intent(MainActivity.this, MainActivity2.class);
        sendImageIntent.putExtra("resId", R.drawable.museumofmodernart);
        sendImageIntent.putExtra("resId2", text);

        sendImageIntent.putExtra("adultPrice", adultPrice);
        sendImageIntent.putExtra("seniorPrice", seniorPrice);
        sendImageIntent.putExtra("studentPrice", studentPrice);

        sendImageIntent.putExtra("adultTicket", ticketPriceAdult);
        sendImageIntent.putExtra("seniorTicket", ticketPriceSenior);
        sendImageIntent.putExtra("studentTicket", ticketPriceStudent);
        sendImageIntent.putExtra("salesTax",salesTax);
        startActivity(sendImageIntent);
    }

    /** method for sending Natural History image + text when Natural History button is clicked */
    public void sendImageNaturalHistory(View view){
        EditText editText = findViewById(R.id.textNaturalHistoryMuseum);
        String text = editText.getText().toString();

        String adultPrice = "Adults: $23";
        String seniorPrice = "Seniors: $18";
        String studentPrice = "Students: $18";

        /** ticket prices to pass along to activity 2 for calculation*/
        ticketPriceAdult = 23;
        ticketPriceSenior = 18;
        ticketPriceStudent = 18;
        salesTax = 0.08875;

        Intent sendImageIntent = new Intent(MainActivity.this, MainActivity2.class);
        sendImageIntent.putExtra("resId", R.drawable.museumofnaturalhistory);
        sendImageIntent.putExtra("resId2", text);

        sendImageIntent.putExtra("adultPrice", adultPrice);
        sendImageIntent.putExtra("seniorPrice", seniorPrice);
        sendImageIntent.putExtra("studentPrice", studentPrice);

        sendImageIntent.putExtra("adultTicket", ticketPriceAdult);
        sendImageIntent.putExtra("seniorTicket", ticketPriceSenior);
        sendImageIntent.putExtra("studentTicket", ticketPriceStudent);
        sendImageIntent.putExtra("salesTax",salesTax);
        startActivity(sendImageIntent);
    }

    /** method for sending Contemporary Art Museum image + text when Contemporary Art button is clicked */
    public void sendImageContemporaryArt(View view){
        EditText editText = findViewById(R.id.textContemporaryMuseum);
        String text = editText.getText().toString();

        String adultPrice = "Adults: $18";
        String seniorPrice = "Seniors: $15";
        String studentPrice = "Students: $12";

        /** ticket prices to pass along to activity 2 for calculation*/
        ticketPriceAdult = 18;
        ticketPriceSenior = 15;
        ticketPriceStudent = 12;
        salesTax = 0.08875;

        Intent sendImageIntent = new Intent(MainActivity.this, MainActivity2.class);
        sendImageIntent.putExtra("resId", R.drawable.newmuseumofcontemporaryart);
        sendImageIntent.putExtra("resId2", text);

        sendImageIntent.putExtra("adultPrice", adultPrice);
        sendImageIntent.putExtra("seniorPrice", seniorPrice);
        sendImageIntent.putExtra("studentPrice", studentPrice);

        sendImageIntent.putExtra("adultTicket", ticketPriceAdult);
        sendImageIntent.putExtra("seniorTicket", ticketPriceSenior);
        sendImageIntent.putExtra("studentTicket", ticketPriceStudent);
        sendImageIntent.putExtra("salesTax",salesTax);
        startActivity(sendImageIntent);
    }

    /** method for sending Metropolitan Museum image + text when MetroPolitan button is clicked */
    public void sendImageMetropolitan(View view){
        EditText editText = findViewById(R.id.textMetropolitanMuseum);
        String text = editText.getText().toString();

        String adultPrice = "Adults: $25";
        String seniorPrice = "Seniors: $17";
        String studentPrice = "Students: $12";

        /** ticket prices to pass along to activity 2 for calculation*/
        ticketPriceAdult = 25;
        ticketPriceSenior = 17;
        ticketPriceStudent = 12;
        salesTax = 0.08875;

        Intent sendImageIntent = new Intent(MainActivity.this, MainActivity2.class);
        sendImageIntent.putExtra("resId", R.drawable.metropolitanmuseum);
        sendImageIntent.putExtra("resId2", text);

        sendImageIntent.putExtra("adultPrice", adultPrice);
        sendImageIntent.putExtra("seniorPrice", seniorPrice);
        sendImageIntent.putExtra("studentPrice", studentPrice);

        sendImageIntent.putExtra("adultTicket", ticketPriceAdult);
        sendImageIntent.putExtra("seniorTicket", ticketPriceSenior);
        sendImageIntent.putExtra("studentTicket", ticketPriceStudent);
        sendImageIntent.putExtra("salesTax",salesTax);

        startActivity(sendImageIntent);
    }

}