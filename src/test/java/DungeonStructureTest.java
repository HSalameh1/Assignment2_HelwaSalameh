//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class DungeonStructureTest {
    @Test
    public void testChamberCreation() {
        Chamber chamber = new Chamber();
        assertEquals(0, chamber.getDoors().size());
        assertEquals(0, chamber.getItems().size());
    }

    @Test
    public void testDoorConnection() {
        Chamber c1 = new Chamber();
        Chamber c2 = new Chamber();
        Door.connect(c1, c2);

        assertEquals(1, c1.getDoors().size());
        assertEquals(c1.getDoors().get(0), c2.getDoors().get(0));
    }

    @Test
    public void testGuardedDoor() {
        Chamber c1 = new Chamber();
        Chamber c2 = new Chamber();
        Monster goblin = new Monster("Goblin", 5, 0, 10);
        Door.connect(c1, c2, goblin);

        assertNotNull(c1.getDoors().get(0).getGuard());
        assertEquals("Goblin", c1.getDoors().get(0).getGuard().getName());
    }
}
