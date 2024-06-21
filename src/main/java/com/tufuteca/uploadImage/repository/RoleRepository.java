package com.tufuteca.uploadImage.repository;

import com.tufuteca.uploadImage.model.Role;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
public interface RoleRepository extends JpaRepository<Role,Long> {

}
