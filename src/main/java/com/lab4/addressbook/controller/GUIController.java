package com.lab4.addressbook.controller;

import com.lab4.addressbook.model.AddressBookModel;
import com.lab4.addressbook.repository.AddressBookRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GUIController {

    private final AddressBookRepo addressBookRepo;

    public GUIController(AddressBookRepo addressBookRepo) {
        this.addressBookRepo = addressBookRepo;
    }

    @GetMapping
    public String getAddressBook(Model model) {
        AddressBookModel addressBookModel = addressBookRepo.findByName("mybook");
        model.addAttribute("AddressBookModel", addressBookModel);
        model.addAttribute("Buddies", addressBookModel.getBuddies());
        return "view2";
    }
}
