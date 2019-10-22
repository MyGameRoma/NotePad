package com.company;

import java.security.PrivateKey;

public class Note extends Record{
    private String text;

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || text.contains(str);
    }

    @Override
    public void askInfo(){
        System.out.print("Write Thear>> ");
        text = Main.scan.next();

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + getId() +
                "text='" + text + '\'' +
                '}';
    }
}
