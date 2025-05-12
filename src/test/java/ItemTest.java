//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {
    @Test
    public void testAxeStrengthBonus() {
        Axe axe = new Axe();
        assertEquals(15, axe.getStrengthBonus()); // Axe should give +15 STR
    }

    @Test
    public void testCharacterEquip() {
        Warrior warrior = new Warrior("Conan");
        Axe axe = new Axe();
        warrior.equip(axe, false); // Equip to right hand
        assertEquals(axe, warrior.getRightHand());
    }
}
