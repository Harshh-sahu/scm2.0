package com.scm.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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


    Page<Contact> getByUser(User user,int page ,int size,String sortBy,String direction);

}
