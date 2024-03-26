package com.documentation.crud_user_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.documentation.crud_user_test.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
