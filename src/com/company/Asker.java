package com.company;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Asker {
    public static final DateTimeFormatter TIME_FORMAT
            = DateTimeFormatter.ofPattern("HH:mm");
    public static final DateTimeFormatter DATE_TIME_FORMAT
            = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final Scanner scan = new Scanner((System.in));
    static {
        scan.useDelimiter("\n");
    }

    public static String asdString(String msg) {

        System.out.print(msg + "> ");
        return scan.next();

    }

    public static LocalDate askData (String msg) {
        while (true) {
            try {
                System.out.print (msg + "> ");
                String answer = scan.next();
                return LocalDate.parse(answer, DATE_TIME_FORMAT);
            }catch (DateTimeParseException e) {
                System.out.print("Not true date format " + DATE_TIME_FORMAT);
            }
        }
    }

    public static LocalTime askTime (String msg) {
        while (true) {
            try {
                System.out.print (msg + "> ");
                String answer = scan.next();
                return LocalTime.parse(answer, TIME_FORMAT);
            }catch (DateTimeParseException e) {
                System.out.print ("Not true time format " + TIME_FORMAT);
            }
        }
    }

    public static int askInt (String msg){
        while (true) {
            try{
                System.out.print(msg);
                String answer = scan.next();
                return Integer.parseInt(answer);
            }catch (NumberFormatException e) {
                System.out.print("Not a number ");
            }

        }

    }

}
