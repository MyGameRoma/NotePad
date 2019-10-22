package com.company;

public abstract class Record {
    private static int counter = 0;
    private int id;



    public Record() {
        counter++;
        this.id = counter;
    }

    public abstract void askInfo();

    public int getId() {
        return id;
    }
}
