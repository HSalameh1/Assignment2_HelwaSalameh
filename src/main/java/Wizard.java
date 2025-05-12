//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Magic-based character. Uses craft for attacks.
 */
public class Wizard extends Character {
    public Wizard(String name) {
        super(name, 100, 10, 30); // High craft, low strength
    }

    @Override
    public int attack(Monster monster) {
        int diceRoll = (int) (Math.random() * 6) + 1; // 1d6
        int totalAttack = getCraft() + diceRoll;
        if (rightHand != null) totalAttack += rightHand.getCraftBonus();
        return totalAttack;
    }
}