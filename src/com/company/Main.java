package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner((System.in));
    static ArrayList<Record> records = new ArrayList<>();

    public static void main(String[] args) {

        scan.useDelimiter("\n");
        System.out.println("Enter your command");
        for (; ; ) {
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

                case "create":
                    createRecord();
                    break;

                case "find":
                    searchResult();
                    break;

                case "delete":
                    deleteID();
                    break;
                default:
                    System.out.println("Enter command");
            }

        }

    }

    private static void deleteID() {
        System.out.print("What ID you want delete?> ");
        int num = scan.nextInt();
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == num) {
                records.remove(i);
                break;
            }
        }
    }

    private static void searchResult() {
        System.out.print("What to find?>>");
        String str = scan.next();
        for (Record r : records) {
            if (r.contains(str)) {
                System.out.println(r);
            }
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
                createRecord(new Person());
                break;
            case "note":
                createRecord(new Note());
                break;

            case "alarm":
                createRecord(new Alarm());
                break;

            case "remind":
                createRecord(new Reminder());
                break;

            default:
                System.out.println("Error");
        }
    }


    private static void createRecord(Record r) {
        r.askInfo();
        records.add(r);
    }


    private static void showHelp() {
        System.out.println("HELP there");
    }
}
