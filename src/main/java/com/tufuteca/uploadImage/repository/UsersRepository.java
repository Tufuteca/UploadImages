package com.tufuteca.uploadImage.repository;

import com.tufuteca.uploadImage.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findUsersByLogin(String username);

    Optional<Users> findByLogin(String username);
}
