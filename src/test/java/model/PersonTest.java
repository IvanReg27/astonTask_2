package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PersonTest {

    @Mock
    Person newPerson;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getId() {
        assertEquals(0, newPerson.getId());
    }

    @Test
    void getUser_id() {
        assertEquals(0, newPerson.getUser_id());
    }

    @Test
    void getCity_id() {
        assertEquals(0, newPerson.getCity_id());
    }

    @Test
    void remoteServiceReturnId() {
        when(newPerson.getId()).thenReturn(1);
        assertEquals(1, newPerson.getId());
    }

    @Test
    void remoteServiceReturnUser_id() {
        when(newPerson.getUser_id()).thenReturn(1);
        assertEquals(1, newPerson.getUser_id());
    }

    @Test
    void remoteServiceReturnCity_id() {
        when(newPerson.getCity_id()).thenReturn(1);
        assertEquals(1, newPerson.getCity_id());
    }

    @Test
    void verificationId() {
        newPerson.getId();
        verify(newPerson).getId();
    }

    @Test
    void verificationUser_id() {
        newPerson.getUser_id();
        verify(newPerson).getUser_id();
    }

    @Test
    void verificationCity_id() {
        newPerson.getCity_id();
        verify(newPerson).getCity_id();
    }
    @Test
    void verificationSetPerson() {
        newPerson.setId(1);
        newPerson.setUser_id(1);
        newPerson.setCity_id(1);
        verify(newPerson).setId(1);
        verify(newPerson).setUser_id(1);
        verify(newPerson).setCity_id(1);
    }
}