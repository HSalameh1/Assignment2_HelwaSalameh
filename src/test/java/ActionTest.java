//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ActionTest {
    @Test
    public void testMoveAction() {
        Chamber c1 = new Chamber();
        Chamber c2 = new Chamber();
        Door.connect(c1, c2);
        Dungeon dungeon = new Dungeon(new Warrior("Test"), c1, c2);

        Action move = new Move(dungeon, c1.getDoors().get(0));
        move.execute();

        assertEquals(c2, dungeon.getCurrentChamber());
    }
}