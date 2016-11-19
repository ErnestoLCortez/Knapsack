package com.example.android.knapsack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;

import java.util.ArrayList;

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







    private void findMaxValueandSolutionPath(int weight[], int value[], int[][] board, ArrayList<String> correctSolutions){
//        int[][] board = new int[5][10];
        boolean[][] solution = new boolean[5][10];

        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 10; j++){
                int option1 = board[i-1][j];

                int option2 = Integer.MIN_VALUE;
                if(weight[i]<=j){
                    option2 = value[i-1] + board[i-1][j-weight[i-1]];
                }

                board[i][j] = Math.max(option1,option2);
                solution[i][j] = (option2 > option1);

//                if(i == 0 || j == 0){
//                    board[i][j] = 0;
//                }else if(weight[i-1]<=j){
//                    board[i][j] = Math.max(value[i-1] + board[i-1][j-weight[i-1]], board[i-1][j]);
//                }else{
//                    board[i][j] = board[i-1][j];
//                }
            }
        }

        for(int i = 5, j = 10; i > 0; i--){
            if(solution[i][j]){
                correctSolutions.add("Item: " + i + ". Value: " + solution[i][j]);
                j = j - weight[i];
            }
        }

    }
}
