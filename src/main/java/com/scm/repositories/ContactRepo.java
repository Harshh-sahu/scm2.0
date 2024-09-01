package com.scm.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scm.entities.Contact;
import com.scm.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ContactRepo extends JpaRepository<Contact,String>  {


    //find the contacts by usetr
Page<Contact>findByUser(User user,Pageable pageable);

    @Query("SELECT c FROM Contact c WHERE c.user.id=:userId")
    List<Contact>findByUserId(@Param("userId") String userId);

}
