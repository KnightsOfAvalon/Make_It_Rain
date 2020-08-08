package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Init variables
    private TextView moneyText;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach money_text view from activity_main.xml to moneyText variable
        moneyText = findViewById(R.id.money_text);

    }

    // onClick method for when button_make_rain is pushed
    public void makeItRain(View v) {

        // Creates variable that will convert int to currency format
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        // moneyCounter will increment whenever the button is clicked
        moneyCounter += 1000;

        // sets moneyText equal to moneyCounter in currency format
        moneyText.setText(String.valueOf(numberFormat.format(moneyCounter)));

        // changes view based on the value of moneyCounter
        if (moneyCounter >= 10000 && moneyCounter < 50000) {
            moneyText.setTextColor(getResources().getColor(R.color.colorAccent));
            moneyText.setTextSize(60);
        } else if (moneyCounter >= 50000 && moneyCounter < 100000) {
            moneyText.setTextColor(getResources().getColor(R.color.colorBigNumber));
            moneyText.setTextSize(68);
        } else if (moneyCounter == 100000) {
            moneyText.setTextColor(getResources().getColor(R.color.colorBiggestNumber));
            Toast.makeText(this, "Whoopee! You're rich!", Toast.LENGTH_LONG).show();
        } else if (moneyCounter > 100000) {
            moneyText.setTextColor(getResources().getColor(R.color.colorBiggestNumber));
        }

    }

    public void startOver(View view) {
        Intent startOver = new Intent(MainActivity.this, MainActivity.class);
        startActivity(startOver);
        Toast.makeText(this, "You've started over! Click 'Make It Rain!' to get more money!", Toast.LENGTH_LONG).show();
    }
}