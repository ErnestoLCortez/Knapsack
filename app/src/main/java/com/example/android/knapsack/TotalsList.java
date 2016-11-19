package com.example.android.knapsack;

import java.util.LinkedList;

public class TotalsList extends LinkedList {

    private int total;

    public TotalsList(){
        super();
        total = 0;
    }

    public boolean add(Object o, int x){
        total += x;
        return add(o);
    }

    public boolean remove(Object o, int x){
        total -= x;
        return remove(o);
    }
}
