package com.zinbig.mongodemo.repositories.JpaRepositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.model.User;

@Repository
public interface JpaAccidentRepository extends JpaRepository<Accident, String> {

}
