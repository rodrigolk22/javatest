package com.rodigolk.javatest.UserRepo;
import com.rodigolk.javatest.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    Page<User> findUserByName(String name, Pageable pageable);
    Page<User> findUserByEmail(String email, Pageable pageable);
}
