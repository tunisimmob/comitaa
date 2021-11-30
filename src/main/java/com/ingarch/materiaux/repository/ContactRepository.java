package com.ingarch.materiaux.repository;
import com.ingarch.materiaux.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@SuppressWarnings("unused")
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {


    @Transactional
    Contact findTop1ByOrderByIdDesc();

}
