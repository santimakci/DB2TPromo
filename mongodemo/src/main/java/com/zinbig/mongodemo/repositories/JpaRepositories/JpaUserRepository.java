package com.zinbig.mongodemo.repositories.JpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}