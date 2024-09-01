package com.scm.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.scm.entities.Contact;
import com.scm.entities.User;
import com.scm.helper.ResourceNotFoundException;
import com.scm.repositories.ContactRepo;
import com.scm.services.ContactService;

@Service
public class contactServiceImpl implements ContactService {

    @Autowired
    private ContactRepo contactRepo;
    @Override
    public Contact save(Contact contact) {
     
        String contactid = UUID.randomUUID().toString();
        contact.setId(contactid);
        return contactRepo.save(contact);
    }

    @Override
    public Contact update(Contact contact) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Contact> getAll() {
      return contactRepo.findAll();
    }

    @Override
    public Contact getById(String id) {
       return contactRepo.findById(id).orElseThrow(()->
        new ResourceNotFoundException("contact not found"+ id)
       );
    }

    @Override
    public void delete(String id) {
        var contact= contactRepo.findById(id).orElseThrow(()->
        new ResourceNotFoundException("contact not found"+ id)
       );
    contactRepo.delete(contact);
    }

  

    @Override
    public List<Contact> getByUserId(String userId) {
      return contactRepo.findByUserId(userId);
    }

    
    @Override
    public Page<Contact> getByUser(User user,int page,int size, String sortBy, String direction) {


       Sort sort = direction.equals("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
      var pageable = PageRequest.of(page, size,sort);
      
       return  contactRepo.findByUser(user,pageable);
    }

    @Override
    public Page<Contact> searchByName(String nameKeyword, int size, int page, String sortBy, String order,User user) {

 Sort sort = order.equals("desc") ? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();

var pageable = PageRequest.of(page,size,sort);
         return contactRepo.findByUserAndNameContaining(user,nameKeyword,pageable);
    }

    @Override
    public Page<Contact> searchByEmail(String emailKeyword, int size, int page, String sortBy, String order,User user) {
    
 Sort sort = order.equals("desc") ? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();

 var pageable = PageRequest.of(page,size,sort);
          return contactRepo.findByUserAndEmailContaining(user,emailKeyword,pageable);
    }

    @Override
    public Page<Contact> searchByPhoneNumber(String phoneNumberKeyword, int size, int page, String sortBy,
        String order,User user) {
          Sort sort = order.equals("desc") ? Sort.by(sortBy).descending():Sort.by(sortBy).ascending();

          var pageable = PageRequest.of(page,size,sort);
                   return contactRepo.findByUserAndPhoneNumberContaining(user,phoneNumberKeyword,pageable);
    }



}

