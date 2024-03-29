package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import model.Game;

import java.io.IOException;

@Getter
@WebServlet(name = "GameController", urlPatterns = {"/stageOne", "/stageTwo", "/stageThree", "/win", "/lost"})
public class GameController extends HttpServlet {

    private Game game;

    private static final String DEFAULT_PLAYER_NAME = "DefaultPlayer";

    @Override
    public void init() throws ServletException {
        super.init();
        String defaultPlayerName = getServletContext().getInitParameter("defaultPlayerName");
        if (defaultPlayerName != null && !defaultPlayerName.isEmpty()) {
            game = new Game(defaultPlayerName);
        } else {
            game = new Game(DEFAULT_PLAYER_NAME);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/stageOne":
                request.getRequestDispatcher(game.startStageOne()).forward(request, response);
                break;
            case "/stageTwo":
                request.getRequestDispatcher(game.startStageTwo()).forward(request, response);
                break;
            case "/stageThree":
                request.getRequestDispatcher(game.startStageThree()).forward(request, response);
                break;
            case "/win":
                request.getRequestDispatcher(game.startWin()).forward(request, response);
                break;
            case "/lost":
                request.getRequestDispatcher(game.startLost()).forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();
        if ("/stageOne".equals(action)) {
            String characterName = request.getParameter("characterName");
            if (characterName != null && !characterName.isEmpty()) {
                request.getSession().setAttribute("characterName", characterName);
                response.sendRedirect(request.getContextPath() + "/stageOne");
            } else {
                request.setAttribute("errorMessage", "Имя персонажа не может быть пустым.");
                request.getRequestDispatcher("/homePage").forward(request, response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}