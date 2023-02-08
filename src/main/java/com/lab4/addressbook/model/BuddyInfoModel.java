package com.lab4.addressbook.model;

import javax.persistence.*;

@Entity
@Table(name = "Buddies")
public class BuddyInfoModel {

    @Id()
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String number;

    public BuddyInfoModel(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public BuddyInfoModel() {
        this.name = "";
        this.number = "";
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) { this.number = number; }

    public String toString() {
        String str = "Name: " + name + " Number: " + number;
        return str;
    }
}
