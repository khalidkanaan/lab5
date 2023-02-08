package com.lab4.addressbook.repository;

import com.lab4.addressbook.model.AddressBookModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddressBookRepo extends CrudRepository<AddressBookModel, Long> {

    AddressBookModel findById(long id);

    AddressBookModel findByName(String name);

}
