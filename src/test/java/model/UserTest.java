package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserTest {

    @Mock
    User newUser;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getId() {
        assertEquals(0, newUser.getId());
    }

    @Test
    void getName() {
        assertEquals(null, newUser.getName());
    }

    @Test
    void getEmail() {
        assertEquals(null, newUser.getEmail());
    }

    @Test
    void getCountry() {
        assertEquals(null, newUser.getCountry());
    }

    @Test
    void getCities_id() {
        assertEquals(0, newUser.getCities_id());
    }

    @Test
    void remoteServiceReturnId() {
        when(newUser.getId()).thenReturn(1);
        assertEquals(1, newUser.getId());
    }

    @Test
    void remoteServiceReturnName() {
        when(newUser.getName()).thenReturn("Ivan");
        assertEquals("Ivan", newUser.getName());
    }

    @Test
    void remoteServiceReturnEmail() {
        when(newUser.getEmail()).thenReturn("makhorin0088@gmail.com");
        assertEquals("makhorin0088@gmail.com", newUser.getEmail());
    }

    @Test
    void remoteServiceReturnCountry() {
        when(newUser.getCountry()).thenReturn("Russia");
        assertEquals("Russia", newUser.getCountry());
    }

    @Test
    void verificationId() {
        newUser.getId();
        verify(newUser).getId();
    }

    @Test
    void verificationName() {
        newUser.getName();
        verify(newUser).getName();
    }

    @Test
    void verificationEmail() {
        newUser.getEmail();
        verify(newUser).getEmail();
    }

    @Test
    void verificationCountry() {
        newUser.getCountry();
        verify(newUser).getCountry();
    }

    @Test
    void verificationCities_id() {
        newUser.getCities_id();
        verify(newUser).getCities_id();
    }
    @Test
    void verificationSetUser() {
        newUser.setId(1);
        newUser.setName("Ivan");
        newUser.setEmail("makhorin0088@gmail.com");
        newUser.setCountry("Russia");
        newUser.setCities_id(1);
        verify(newUser).setId(1);
        verify(newUser).setName("Ivan");
        verify(newUser).setEmail("makhorin0088@gmail.com");
        verify(newUser).setCountry("Russia");
        verify(newUser).setCities_id(1);
    }
    @Test
    void verificationUserOther() {
        assertEquals(null, newUser.getName());
        verify(newUser, times(1)).getName();
        verify(newUser, atLeast(1)).getName();
        verify(newUser, atMost(3)).getName();
        verify(newUser, only()).getName();
    }
}