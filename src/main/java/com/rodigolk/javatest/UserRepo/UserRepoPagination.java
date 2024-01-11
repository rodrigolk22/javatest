package com.rodigolk.javatest.UserRepo;
import com.rodigolk.javatest.entity.User;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface UserRepoPagination extends PagingAndSortingRepository<User,Integer>{
    List<User> findAllUserByName(String name, Pageable pageable);
    List<User> findAllUserByEmail(String email, Pageable pageable);
}
