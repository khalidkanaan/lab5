package com.lab4.addressbook.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "AddressBooks")
public class AddressBookModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<BuddyInfoModel> buddies;
    public AddressBookModel(String name) {
        this.name = name;
        buddies = new ArrayList<>();
    }
    public AddressBookModel() {
        this.name = "";
        buddies = new ArrayList<>();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void addBuddy(BuddyInfoModel buddy) {
        buddies.add(buddy);
    }

    public void removeBuddy(String nameOfBuddy) {
        for (int i = 0; i < buddies.size(); i++) {
            if ((buddies.get(i).getName()).equals(nameOfBuddy)) {
                buddies.remove(i);
                break;
            }
        }
    }
    public List<BuddyInfoModel> getBuddies() {
        return buddies;
    }
    public void setBuddies(List<BuddyInfoModel> buddies) {
        this.buddies = buddies;
    }

}
