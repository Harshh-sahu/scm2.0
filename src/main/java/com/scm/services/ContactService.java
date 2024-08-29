package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;
import com.scm.entities.User;

public interface ContactService {

    Contact save(Contact contact);

    // upadate contact

    Contact update(Contact contact);

    List<Contact> getAll();

    Contact getById(String id);

    // delete contact
    void delete(String id);

    List<Contact> searchByName(String name, String email, String phoneNumber);

    List<Contact> getByUserId(String userId);


    List<Contact> getByUser(User user);

}
