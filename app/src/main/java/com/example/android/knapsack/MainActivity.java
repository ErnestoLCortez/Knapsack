package com.example.android.knapsack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    TotalsList<DragItems> knapsackWeight;
    TotalsList<DragItems> knapsackValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        knapsackValue = new TotalsList<>();
        knapsackWeight = new TotalsList<>();


    }


    private class DragListener implements View.OnDragListener {

        public boolean onDrag(View v, DragEvent event) {

            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    v.invalidate();
                    return true;
                case DragEvent.ACTION_DROP:
                    DragItems draggedItem = (DragItems)event.getLocalState();
                    knapsackWeight.add(draggedItem, draggedItem.getWeight());
                    knapsackValue.add(draggedItem, draggedItem.getValue());

                    return true;
            }
            return false;
        }
    }









}
