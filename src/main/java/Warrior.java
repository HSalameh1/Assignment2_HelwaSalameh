//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Strength-based character. Uses strength for attacks.
 */
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 120, 30, 5);
    }

    @Override
    public int attack(Monster monster) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        int totalAttack = getStrength() + diceRoll;
        if (getLeftHand() != null) totalAttack += getLeftHand().getStrengthBonus();
        return totalAttack;
    }
}
