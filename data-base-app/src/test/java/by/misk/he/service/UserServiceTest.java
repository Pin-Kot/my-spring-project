package by.misk.he.service;

import by.minsk.he.models.UserModel;
import by.minsk.he.repository.UserRepository;
import by.minsk.he.services.UserService;
import by.misk.he.stubs.UserStubs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static by.misk.he.stubs.UserStubs.USER_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private final UserStubs userStubsTest = new UserStubs();

    @Test
    void insertUser_then_return() {

        UserModel testUser = userStubsTest.createUserStubs();

        when(userRepository.save(
                        eq(testUser)
                )
        ).thenReturn(
                testUser
        );
        UserModel actualUser = userService.insertUser(testUser);
        Assertions.assertEquals(actualUser, testUser);
        verify(userRepository, new Times(1)).save(testUser);
    }

    @Test
    void insertCar_then_throws_exception() {

        UserModel testUser = userStubsTest.createUserStubs();

        when(userRepository.save(
                        eq(testUser)
                )
        ).thenThrow(new RuntimeException("") {
        });
        assertThrows(RuntimeException.class, () -> userService.insertUser(testUser));
        verify(userRepository, new Times(1)).save(testUser);
    }

    @Test
    void findCarById_then_return() {

        UserModel testUser = userStubsTest.createUserStubs();
        testUser.setUserId(USER_ID);

        when(userRepository.findById(
                        eq(USER_ID)
                )
        ).thenReturn(
                Optional.of(testUser)
        );
        UserModel actualUser = userService.findUserById(USER_ID);
        Assertions.assertEquals(actualUser, testUser);
        verify(userRepository, new Times(1)).findById(USER_ID);
    }

    @Test
    void findCarById_then_throws_exception() {

        when(userRepository.findById(
                eq(USER_ID))
        ).thenThrow(new IllegalArgumentException("") {
        });
        assertThrows(IllegalArgumentException.class, () -> userService.findUserById(USER_ID));
        verify(userRepository, new Times(1)).findById(USER_ID);
    }

    @Test
    void findAll_then_return() {

        UserModel testUser1 = userStubsTest.createUserStubs();
        UserModel testUser2 = userStubsTest.createUserStubs();
        List<UserModel> testList = new ArrayList<>(Arrays.asList(testUser1, testUser2));

        when(userRepository.findAll()
        ).thenReturn(
                testList
        );
        List<UserModel> actualList = userService.findAll();
        Assertions.assertIterableEquals(actualList, testList);
        verify(userRepository, new Times(1)).findAll();
    }

    @Test
    void updateCar_then_return() {

        UserModel testUser = userStubsTest.createUserStubs();
        testUser.setUserId(USER_ID);

        when(userRepository.existsById(
                testUser.getUserId())
        ).thenReturn(true);

        when(userRepository.save(
                eq(testUser))
        ).thenReturn(
                testUser
        );
        UserModel actualUser = userService.updateUser(testUser);
        Assertions.assertEquals(actualUser, testUser);

        verify(userRepository, new Times(1)).existsById(USER_ID);
        verify(userRepository, new Times(1)).save(testUser);
    }

    @Test
    void updateCar_then_throws_exception() {

        UserModel testUser = userStubsTest.createUserStubs();
        testUser.setUserId(USER_ID);

        when(userRepository.existsById(
               USER_ID)
        ).thenThrow(new NoSuchElementException("") {
        });
        assertThrows(NoSuchElementException.class, () -> userService.updateUser(testUser));
        verify(userRepository, new Times(1)).existsById(USER_ID);
        verify(userRepository, new Times(0)).save(testUser);
    }

    @Test
    void deleteCar_then_return() {

        UserModel testUser = userStubsTest.createUserStubs();
        testUser.setUserId(USER_ID);

        when(userRepository.findById(
                        eq(USER_ID)
                )
        ).thenReturn(
                Optional.of(testUser)
        );
        doNothing().when(userRepository).delete(testUser);

        UserModel actualUser = userService.deleteUser(USER_ID);
        Assertions.assertEquals(actualUser, testUser);
        verify(userRepository, new Times(1)).findById(USER_ID);
        verify(userRepository, new Times(1)).delete(testUser);
    }
}
