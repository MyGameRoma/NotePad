package com.company;

import javax.swing.*;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    static ArrayList<Record> records = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Enter your command");
        for (; ; ) {
            String cmd = Asker.asdString("Type");
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

                case "expired":
                    listExpiredRecords();
                    break;

                case "dis":
                    disExpiredRecord();
                    break;

                case "find":
                    searchResult();
                    break;

                case "clean":
                    cleanName();
                    break;

                case "delete":
                    deleteID();
                    break;

                default:
                    System.out.println("Enter command");
            }
        }
    }

    private static void disExpiredRecord() {
        int id = Asker.askInt("what id Dismiss?");
        for (Record r : records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (r.getId() == id) {
                    e.dissMissExpired();
                }
            }
        }
    }

    private static void listExpiredRecords() {
        for (Record r : records) {
            if (r instanceof Expirable) {
                Expirable e = (Expirable) r;
                if (e.isExpired()) {
                    System.out.println(r);
                }
            }
        }

    }

    private static void cleanName() {
        String strc = Asker.asdString("What you want clean?");
        records.removeIf(r -> r.contains(strc));
//        while (iterator.hasNext()) {
//            Record r = iterator.next();
//            if (r.contains(strc)) {
//               iterator.remove();
//            }
//        }
    }


    private static void deleteID() {
        int num = Asker.askInt("What ID you want delete?");
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            if (r.getId() == num) {
                records.remove(i);
                break;
            }
        }
    }

    private static void searchResult() {
        String str = Asker.asdString("What to find?");
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
        String type = Asker.asdString("What you want create?");
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
