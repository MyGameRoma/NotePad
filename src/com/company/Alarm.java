package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Alarm extends Note {
    public static final DateTimeFormatter TIME_FORMAT
            = DateTimeFormatter.ofPattern("HH:mm");
    private LocalTime time;

    @Override
    public void askInfo() {
        super.askInfo();
        System.out.print("Time to alarm ");
        String strtime = Main.scan.next();
        time = LocalTime.parse(strtime, TIME_FORMAT);
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || time.format(TIME_FORMAT).contains(str);
    }


    public LocalTime getTime() {
        return time; }

    public void setTime(LocalTime time) {
        this.time = time; }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + getId() +
                "text='" + getText() + '\'' +
                "Time='" + time.format(TIME_FORMAT) + '\'' +
                '}';
    }
}
