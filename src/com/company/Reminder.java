package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reminder extends Alarm {
    public static final DateTimeFormatter DATE_TIME_FORMAT
            = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date;

    @Override
    public void askInfo() {
        super.askInfo();
        System.out.print("Day to reminder ");
        String strdate = Main.scan.next();
        date = LocalDate.parse(strdate, DATE_TIME_FORMAT);

    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || date.format(DATE_TIME_FORMAT).contains(str);
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                "text='" + getText() + '\'' +
                "Time='" + getTime() + '\'' +
                "date=" + date.format(DATE_TIME_FORMAT) + '\'' +
                '}';
    }
}
