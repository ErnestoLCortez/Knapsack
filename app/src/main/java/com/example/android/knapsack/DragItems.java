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

        value = random.nextInt(10)+1;
        weight = random.nextInt(9)+1;

        ((TextView)getChildAt(0)).setText(value);
        String temp = "$" + weight;
        ((TextView)getChildAt(1)).setText(temp);
    }

    public int getValue(){return value;}

    public int getWeight(){return weight;}

}
