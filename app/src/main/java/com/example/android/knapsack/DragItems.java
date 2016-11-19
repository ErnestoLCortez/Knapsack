package com.example.android.knapsack;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class DragItems extends LinearLayout {

    private int value;
    private int weight;

    public DragItems(Context context){
        super(context);

        Random random = new Random();

        value = random.nextInt(40)+5;
        weight = random.nextInt(10)+1;

        String temp1 = "Value: $" + value;
        ((TextView)getChildAt(0)).setText(temp1);
        String temp2 = "Weight: " + weight;
        ((TextView)getChildAt(1)).setText(temp2);
    }

    public int getValue(){return value;}

    public int getWeight(){return weight;}

}
