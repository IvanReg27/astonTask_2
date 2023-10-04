package web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CityServletTest {

    @Mock
    CityServlet newCityServlet;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init() {
        assertEquals(null, newCityServlet.getInitParameterNames());
    }

    @Test
    void doGet() {
        assertEquals(null, newCityServlet.getServletName());
    }
    @Test
    void remoteServiceReturnInit() {
        when(newCityServlet.getInitParameterNames()).thenReturn(null);
    }
    @Test
    void remoteServiceReturnDoGet() {
        when(newCityServlet.getServletName()).thenReturn(null);
    }
    @Test
    void verificationInit() {
        newCityServlet.init();
        verify(newCityServlet).init();
    }
    @Test
    void verificationDoGet() {
        newCityServlet.getServletName();
        verify(newCityServlet).getServletName();
    }
}