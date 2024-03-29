package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testSetName() {
        Player player = new Player("InitialName");
        player.setName("NewName");

        assertEquals("NewName", player.getName());
    }
}