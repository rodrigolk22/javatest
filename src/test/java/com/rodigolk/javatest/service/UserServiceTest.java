package com.rodigolk.javatest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.rodigolk.javatest.DTO.UserUpdateDTO;
import com.rodigolk.javatest.UserRepo.UserRepo;
import com.rodigolk.javatest.entity.Profile;
import com.rodigolk.javatest.entity.User;

public class UserServiceTest {
    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceIMPL userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void GetUser() {
        Profile profile = new Profile(1, "admin");
        User mockUser = new User(1, "Rodrigo", profile, "teste@email.com", "1234");
        when(userRepo.existsById(1)).thenReturn(true);
    }

    @Test
    public void createUser() {
        User createdUser = new User(1, "Rodrigo", new Profile(1, "Admin"), "1234", "teste@email.com");

        when(userRepo.save(any(User.class))).thenReturn(createdUser);

        String result = userService.addUser(createdUser);

        assertNotNull(result);
        assertEquals("Rodrigo", result);

        verify(userRepo, times(1)).save(nullable(User.class));
    }

    @Test
    public void testSaveUser() {

        UserUpdateDTO userUpdateDTO = new UserUpdateDTO(1, "Rodrigo", new Profile(1, "Admin"), "1234", "teste@email.com");
        userUpdateDTO.setName("Rodrigo2");
        userUpdateDTO.setEmail("teste@email.com");
        userUpdateDTO.setPassword("1234");

        String result = userService.updateUser(userUpdateDTO);
        assertEquals("Rodrigo", result);

    }

    @Test
    public void testDeleteUser() {
        int userId = 1;

        boolean result = userService.deleteUser(userId);

        assertNotNull(result);
    }
}
