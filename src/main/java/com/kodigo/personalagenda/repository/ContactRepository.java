package com.kodigo.personalagenda.repository;

import com.kodigo.personalagenda.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
