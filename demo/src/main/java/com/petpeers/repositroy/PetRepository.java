package com.petpeers.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petpeers.entities.User;

@Repository
public interface PetRepository extends JpaRepository<User, Long>{

}
