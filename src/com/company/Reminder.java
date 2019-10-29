package com.company;

import java.time.LocalDate;

public class Reminder extends Alarm {
    private LocalDate date;

    @Override
    public void askInfo() {
        super.askInfo();
        date = Asker.askData("Date?> ");
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || date.format(Asker.DATE_TIME_FORMAT).contains(str);
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
                "date=" + date.format(Asker.DATE_TIME_FORMAT) + '\'' +
                '}';
    }
}
