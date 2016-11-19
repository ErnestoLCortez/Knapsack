package com.example.android.knapsack;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class DragItems extends LinearLayout {

    private int value;
    private int weight;

    public DragItems(Context context){
        super(context);


    }

    public DragItems(Context context, AttributeSet attrs){
        super(context, attrs);


    }

    public DragItems(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);


    }

    public DragItems(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    public void initItemStats(){
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

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            return startDrag(
                    ClipData.newPlainText("", ""),
                    new View.DragShadowBuilder(this),
                    this,
                    0
            );
        }

        return super.onTouchEvent(motionEvent);
    }

}
