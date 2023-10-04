package web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserServletTest {

    @Mock
    UserServlet newUserServlet;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init() {
        assertEquals(null, newUserServlet.getInitParameterNames());
    }

    @Test
    void doGet() {
        assertEquals(null, newUserServlet.getServletName());
    }

    @Test
    void remoteServiceReturnInit() {
        when(newUserServlet.getInitParameterNames()).thenReturn(null);
    }

    @Test
    void remoteServiceReturnDoGet() {
        when(newUserServlet.getServletName()).thenReturn(null);
    }

    @Test
    void verificationInit() {
        newUserServlet.init();
        verify(newUserServlet).init();
    }

    @Test
    void verificationDoGet() {
        newUserServlet.getServletName();
        verify(newUserServlet).getServletName();
    }
}