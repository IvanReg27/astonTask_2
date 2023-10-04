package web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PersonServletTest {

    @Mock
    PersonServlet newPersonServlet;
    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void init() {
        assertEquals(null, newPersonServlet.getInitParameterNames());
    }

    @Test
    void doGet() {
        assertEquals(null, newPersonServlet.getServletName());
    }
    @Test
    void remoteServiceReturnInit() {
        when(newPersonServlet.getInitParameterNames()).thenReturn(null);
    }
    @Test
    void remoteServiceReturnDoGet() {
        when(newPersonServlet.getServletName()).thenReturn(null);
    }
    @Test
    void verificationInit() {
        newPersonServlet.init();
        verify(newPersonServlet).init();
    }

    @Test
    void verificationDoGet() {
        newPersonServlet.getServletName();
        verify(newPersonServlet).getServletName();
    }
}