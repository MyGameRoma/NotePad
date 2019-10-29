package com.company;

import javax.swing.*;

public class Person extends Record{
    private String name;
    private String surname;
    private String phone;
    private String email;


    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || name.contains(str)
                || surname.contains(str)
                || phone.contains(str)
                || email.contains(str);

    }

    @Override
    public void askInfo() {
        name = Asker.asdString("Name");
        surname = Asker.asdString("Surname");
        phone = Asker.asdString("phone");
        email = Asker.asdString("data");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
