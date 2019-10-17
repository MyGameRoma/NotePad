package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner((System.in));
    static ArrayList<Record> records = new ArrayList<>();
    public static void main(String[] args) {

        System.out.println("Enter your command");
        for ( ; ; ){
            System.out.println("Type>");
            String cmd = scan.next();
            switch (cmd) {
                case "exit":
                    System.out.println("good bay");
                    return;
                case "help":
                    showHelp();
                    break;

                case "list":
                showList();
                break;
                case "note":
                    showNote();

                case "create":
                    createRecord();
                    break;


                default:
                    System.out.println("Enter command");
            }

        }

    }

    private static void showNote() {
        for (Record p : records){
            System.out.println(p);
        }
    }

    private static void showList() {

        for (Record p : records) {
 //           System.out.printf( "%d\t%s\t%s\t%s\n",
 //                   p.getId(),
 //                   p.getName(),
 //                   p.getSurname(),
 //                   p.getPhone());
            System.out.println(p);
        }

    }

    private static void createRecord() {
        System.out.print("What you want create? ");
        String type = scan.next();
        switch (type) {
            case "person":
                createPerson();
                break;
            case "note":
                createNote();
                break;
            default:
                System.out.println("Error");
        }
    }

    private static void createNote() {
        Note n = new Note();
        n.writeText();
        records.add(n);

    }

    private static void createPerson() {
        Person p = new Person();
        p.askInfo();
        records.add(p);
    }


    private static void showHelp() {
        System.out.println("HELPPP theare");
    }
}
