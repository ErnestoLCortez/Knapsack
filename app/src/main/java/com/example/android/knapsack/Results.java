package com.example.android.knapsack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Brian on 11/19/2016.
 */

public class Results extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Bundle extras = getIntent().getExtras();

        ArrayAdapter<String> mYourChoicesAdapter = new ArrayAdapter<String>(
                this,
                R.layout.results,
                R.id.yourChoices_list,
                extras.getStringArrayList("yourChoices")
        );

        ArrayAdapter<String> mGoodChoicesAdapter = new ArrayAdapter<String>(
                this,
                R.layout.results,
                R.id.bestChoices_list,
                extras.getStringArrayList("bestChoices")
        );

        TextView userMaxValue = (TextView) findViewById(R.id.maxValueUser);
        userMaxValue.setText(extras.getString("userMaxValue"));

        TextView maxValueEver = (TextView) findViewById(R.id.maxValueEver);
        userMaxValue.setText(extras.getString("maxValueEver"));

    }
}
