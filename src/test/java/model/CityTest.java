package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CityTest {

    @Mock
    City newCity;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getId() {
        assertEquals(0, newCity.getId());
    }

    @Test
    void getCity() {
        assertEquals(null, newCity.getCity());
    }

    @Test
    void remoteServiceReturnId() {
        when(newCity.getId()).thenReturn(1);
        assertEquals(1, newCity.getId());
    }

    @Test
    void remoteServiceReturnCity() {
        when(newCity.getCity()).thenReturn("Moscow");
        assertEquals("Moscow", newCity.getCity());
    }

    @Test
    void verificationId() {
        newCity.getId();
        verify(newCity).getId();
    }

    @Test
    void verificationCity() {
        newCity.getCity();
        verify(newCity).getCity();
    }
    @Test
    void verificationSetCity() {
        newCity.setId(1);
        newCity.setCity("Moscow");
        verify(newCity).setId(1);
        verify(newCity).setCity("Moscow");
    }
}