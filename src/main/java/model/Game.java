package model;

import lombok.Getter;

@Getter
public class Game {
    private final Player player;

    public Game(String playerName) {
        this.player = new Player(playerName);
    }

    public String startStageOne() {
        return "/WEB-INF/views/stageOne.jsp";
    }

    public String startStageTwo() {
        return "/WEB-INF/views/stageTwo.jsp";
    }

    public String startStageThree() {
        return "/WEB-INF/views/stageThree.jsp";
    }

    public String startWin() {
        return "/WEB-INF/views/win.jsp";
    }

    public String startLost() {
        return "/WEB-INF/views/lost.jsp";
    }
}
