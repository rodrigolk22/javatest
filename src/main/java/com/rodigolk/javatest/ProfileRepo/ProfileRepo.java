package com.rodigolk.javatest.ProfileRepo;
import com.rodigolk.javatest.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface ProfileRepo extends JpaRepository<Profile,Integer>{
    
}
