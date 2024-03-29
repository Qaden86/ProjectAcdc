package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game("Player");
    }

    @Test
    public void testStartStageOne() {
        assertEquals("/WEB-INF/views/stageOne.jsp", game.startStageOne());
    }

    @Test
    public void testStartStageTwo() {
        assertEquals("/WEB-INF/views/stageTwo.jsp", game.startStageTwo());
    }

    @Test
    public void testStartStageThree() {
        assertEquals("/WEB-INF/views/stageThree.jsp", game.startStageThree());
    }

    @Test
    public void testStartWin() {
        assertEquals("/WEB-INF/views/win.jsp", game.startWin());
    }

    @Test
    public void testStartLost() {
        assertEquals("/WEB-INF/views/lost.jsp", game.startLost());
    }

    @Test
    public void testPlayerInitialization() {
        assertNotNull(game.getPlayer());
        assertEquals("Player", game.getPlayer().getName());
    }
}