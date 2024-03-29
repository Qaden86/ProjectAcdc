package filter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class HomePageRedirectFilterTest {

    @Mock
    private ServletRequest mockRequest;

    @Mock
    private ServletResponse mockResponse;

    @Mock
    private FilterChain mockFilterChain;

    @Mock
    private RequestDispatcher mockRequestDispatcher;

    private HomePageRedirectFilter filter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        filter = new HomePageRedirectFilter();
    }


    @Test
    public void testInit() {
        FilterConfig mockFilterConfig = Mockito.mock(FilterConfig.class);
        HomePageRedirectFilter filter = new HomePageRedirectFilter();

        try {
            filter.init(mockFilterConfig);
            assertFalse(false, "Expected no ServletException to be thrown");
        } catch (ServletException e) {
            fail("Unexpected ServletException thrown");
        }
    }

    @Test
    public void testDoFilter() throws Exception {
        when(mockRequest.getRequestDispatcher("/WEB-INF/views/home.jsp")).thenReturn(mockRequestDispatcher);

        filter.doFilter(mockRequest, mockResponse, mockFilterChain);

        verify(mockRequestDispatcher).forward(mockRequest, mockResponse);
        verify(mockFilterChain, never()).doFilter(mockRequest, mockResponse);
    }
}
