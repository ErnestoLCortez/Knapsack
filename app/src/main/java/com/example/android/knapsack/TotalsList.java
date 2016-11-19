package com.example.android.knapsack;

import java.util.LinkedList;

import static android.R.attr.y;


public class TotalsList<E> extends LinkedList<E> {

    private int total;

    public TotalsList(){
        super();
        total = 0;
    }


    public boolean add(E x, int y){
        total += y;
        return super.add(x);
    }

    public boolean remove(E x, int y){
        total -= y;
        return super.remove(x);
    }
}
