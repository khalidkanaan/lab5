package com.lab4.addressbook.service;
import com.lab4.addressbook.model.BuddyInfoModel;
import java.util.List;

public interface AddressBookService {
    void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel);
    void removeBuddy(String addressBookName, String firstName);
    List<BuddyInfoModel> getBuddies(String addressBookName);
}
