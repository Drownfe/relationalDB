package com.sofkaU.relationalDB.repository;

import com.sofkaU.relationalDB.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
