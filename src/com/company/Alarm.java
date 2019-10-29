package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Alarm extends Note implements Expirable{
    private LocalTime time;
    private LocalDate disMissedAdd;

    @Override
    public void askInfo() {
        super.askInfo();
        time = Asker.askTime("time> ");
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || time.format(Asker.TIME_FORMAT).contains(str);
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
                "Time='" + time.format(Asker.TIME_FORMAT) + '\'' +
                '}';
    }

    @Override
    public boolean isExpired() {
        if (LocalDate.now().equals(disMissedAdd)){
            return false;
        }
        return LocalTime.now().isAfter(time);
    }

    @Override
    public void dissMissExpired() {
        disMissedAdd = LocalDate.now();
    }

}
