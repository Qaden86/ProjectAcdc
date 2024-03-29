package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GameControllerTest {
    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private Game game;

    @Mock
    private ServletConfig servletConfig;

    @Mock
    private ServletContext servletContext;

    @Mock
    private HttpSession session;

    @InjectMocks
    private GameController controller;


    @BeforeEach
    void setUp() throws ServletException {
        MockitoAnnotations.openMocks(this);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(request.getSession()).thenReturn(session);
        controller.init(servletConfig);
        lenient().when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    void testDoGet_StageOne() throws Exception {
        when(request.getServletPath()).thenReturn("/stageOne");
        when(game.startStageOne()).thenReturn("/WEB-INF/views/stageOne.jsp");

        controller.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoGet_StageTwo() throws Exception {
        when(request.getServletPath()).thenReturn("/stageTwo");
        when(game.startStageTwo()).thenReturn("/WEB-INF/views/stageTwo.jsp");

        controller.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoGet_StageThree() throws Exception {
        when(request.getServletPath()).thenReturn("/stageThree");
        when(game.startStageThree()).thenReturn("/WEB-INF/views/stageThree.jsp");

        controller.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoGet_StageWin() throws Exception {
        when(request.getServletPath()).thenReturn("/win");
        when(game.startWin()).thenReturn("/WEB-INF/views/win.jsp");

        controller.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoGet_StageLost() throws Exception {
        when(request.getServletPath()).thenReturn("/lost");
        when(game.startLost()).thenReturn("/WEB-INF/views/lost.jsp");

        controller.doGet(request, response);

        verify(requestDispatcher).forward(request, response);
    }

    @Test
    void testDoGet_InvalidAction() throws Exception {
        when(request.getServletPath()).thenReturn("/invalidAction");

        controller.doGet(request, response);

        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Test
    void testInit_WithDefaultPlayerName() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getInitParameter("defaultPlayerName")).thenReturn(null);

        controller.init(servletConfig);

        assertEquals("DefaultPlayer", controller.getGame().getPlayer().getName());
    }

    @Test
    void testInit_WithCustomPlayerName() throws ServletException {
        String customPlayerName = "CustomPlayer";
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletContext.getInitParameter("defaultPlayerName")).thenReturn(customPlayerName);

        controller.init(servletConfig);

        assertEquals(customPlayerName, controller.getGame().getPlayer().getName());
    }

    @Test
    void testDoPost_ValidCharacterName_RedirectToStageOne() throws Exception {
        when(request.getServletPath()).thenReturn("/stageOne");
        when(request.getParameter("characterName")).thenReturn("Alice");

        controller.doPost(request, response);

        verify(request.getSession()).setAttribute("characterName", "Alice");
        verify(response).sendRedirect(request.getContextPath() + "/stageOne");
    }

    @Test
    void testDoPost_EmptyCharacterName_ForwardToHomePage() throws Exception {
        when(request.getServletPath()).thenReturn("/stageOne");
        when(request.getParameter("characterName")).thenReturn("");

        controller.doPost(request, response);

        verify(request).setAttribute("errorMessage", "Имя персонажа не может быть пустым.");
        verify(request.getRequestDispatcher("/homePage")).forward(request, response);
    }

    @Test
    void testDoPost_InvalidAction_SendNotFoundError() throws Exception {
        when(request.getServletPath()).thenReturn("/invalidAction");

        controller.doPost(request, response);

        verify(response).sendError(HttpServletResponse.SC_NOT_FOUND);
    }


}
