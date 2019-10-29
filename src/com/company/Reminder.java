package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Alarm implements Expirable {
    private LocalDate date;
    private boolean disdata;

    @Override
    public boolean isExpired() {
        if (disdata == true) {
            return false;
        }
        var dt = LocalDateTime.of(date, getTime());
        return LocalDateTime.now().isAfter(dt);
    }

    @Override
    public void dissMissExpired() {
        disdata = true;
    }



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
