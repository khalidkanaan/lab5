package com.lab4.addressbook.service;

import com.lab4.addressbook.model.AddressBookModel;
import com.lab4.addressbook.model.BuddyInfoModel;
import com.lab4.addressbook.repository.AddressBookRepo;
import com.lab4.addressbook.repository.BuddyInfoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private final AddressBookRepo addressBookRepo;
    private final BuddyInfoRepo buddyInfoRepo;

    public AddressBookServiceImpl(AddressBookRepo addressBookRepo, BuddyInfoRepo buddyInfoRepo) {
        this.addressBookRepo = addressBookRepo;
        this.buddyInfoRepo = buddyInfoRepo;
    }

    @Override
    public void saveBuddy(String addressBookName, BuddyInfoModel buddyInfoModel) {
        BuddyInfoModel b = buddyInfoRepo.save(buddyInfoModel);
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        if (addressBookModel != null) {
            addressBookModel.addBuddy(b);
        } else {
            addressBookModel = new AddressBookModel(addressBookName);
            addressBookModel.addBuddy(b);
        }
        addressBookRepo.save(addressBookModel);

    }

    @Override
    public void removeBuddy(String addressBookName, String name) {
        BuddyInfoModel buddyInfoModel = buddyInfoRepo.findByName(name);
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        addressBookModel.removeBuddy(name);
        buddyInfoRepo.delete(buddyInfoModel);
        addressBookRepo.save(addressBookModel);
    }

    @Override
    public List<BuddyInfoModel> getBuddies(String addressBookName) {
        AddressBookModel addressBookModel = addressBookRepo.findByName(addressBookName);
        return addressBookModel.getBuddies();
    }


}
