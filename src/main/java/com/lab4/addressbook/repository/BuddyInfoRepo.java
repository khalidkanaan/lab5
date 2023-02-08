package com.lab4.addressbook.repository;

import com.lab4.addressbook.model.BuddyInfoModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuddyInfoRepo extends CrudRepository<BuddyInfoModel, Long> {
    BuddyInfoModel findByName(String name);
}
