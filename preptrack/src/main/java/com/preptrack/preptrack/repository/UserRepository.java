package com.preptrack.preptrack.repository;

import com.preptrack.preptrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
