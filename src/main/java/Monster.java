//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Enemy characters guarding doors in the dungeon.
 */
public class Monster {
    private String name;
    private int health;
    private int strength; // 0 if craft-based
    private int craft;    // 0 if strength-based

    public Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public boolean isDefeated() {
        return health <= 0;
    }
    public void takeDamage(int damage) {
        health -= damage;
    }

    public int attack(Character target) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        int totalAttack = (strength > 0) ? strength + diceRoll : craft + diceRoll;
        target.takeDamage(totalAttack);
        return totalAttack;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }
    public int getCraft() {
        return craft;
    }

    public int getHealth() {
        return health;
    }
}
