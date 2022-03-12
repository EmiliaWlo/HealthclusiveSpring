package com.qa.healthclusivespring.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.healthclusivespring.domain.Therapists;
@Repository
public interface TherapistsRepo extends JpaRepository<Therapists, Long> {

	
}
