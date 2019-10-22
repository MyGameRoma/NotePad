package com.company;

import java.util.SplittableRandom;

public abstract class Record {
    private static int counter = 0;
    private int id;


    public Record() {
        counter++;
        this.id = counter;
    }

    public boolean contains(String str);{
        String strID = Integer.toString(id);

        return Integer.toString(id)
    }

    public abstract void askInfo();

    public int getId() {
        return id;
    }
}
