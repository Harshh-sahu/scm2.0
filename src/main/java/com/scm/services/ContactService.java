package com.scm.services;

import java.util.List;

import com.scm.entities.Contact;

public interface ContactService {

    Contact save(Contact contact);

    // upadate contact

    Contact update(Contact contact);

    List<Contact> getAll();

    Contact getById(String id);

    // delete contact
    void delete(String id);

    List<Contact> search(String name, String email, String phoneNumber);

    List<Contact> getByUserId(String userId);

}
