package com.example.android.knapsack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }










    private int findMaxValue(int weight[], int value[]){
        int[][] board = new int[5][10];

        for(int i = 0; i <= 5; i++){
            for(int j = 0; j <= 10; j++){
                if(i == 0 || j == 0){
                    board[i][j] = 0;
                }else if(weight[i-1]<=j){
                    board[i][j] = Math.max(value[i-1] + board[i-1][j-weight[i-1]], board[i-1][j]);
                }else{
                    board[i][j] = board[i-1][j];
                }
            }
        }

        return board[5][10];
    }

}
