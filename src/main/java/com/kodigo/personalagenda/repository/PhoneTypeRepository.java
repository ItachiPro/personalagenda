package com.kodigo.personalagenda.repository;

import com.kodigo.personalagenda.model.PhoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneTypeRepository extends JpaRepository<PhoneType, Long> {
}
