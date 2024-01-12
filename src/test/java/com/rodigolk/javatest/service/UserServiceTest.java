package com.rodigolk.javatest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rodigolk.javatest.UserRepo.UserRepo;
import com.rodigolk.javatest.entity.Profile;
import com.rodigolk.javatest.entity.User;

public class UserServiceTest {
    @Mock
    private UserRepo userRepository;

    @InjectMocks
    private UserServiceIMPL userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUser() {
        Profile profile = new Profile(1, "admin");
        User mockUser = new User(1, "TestUser", profile, "test@example.com", "password");
        when(userRepository.existsById(1)).thenReturn(true);
    }
}
