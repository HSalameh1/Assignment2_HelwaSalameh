//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Abstract base class for all characters (player + monsters).
 * Manages health, strength, craft, and equipped items.
 */
public abstract class Character {
    private String name;
    private int health;
    private int strength;
    private int craft;
    private List<Item> inventory = new ArrayList<>();
    private Item leftHand;  // Equipped item (left slot)
    private Item rightHand; // Equipped item (right slot)

    public Character(String name, int health, int strength, int craft) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.craft = craft;
    }

    protected Item getLeftHand() {
        return leftHand;
    }

    protected Item getRightHand() {
        return rightHand;
    }

    public int getStrength() {
        return strength;
    }

    public abstract int attack(Monster monster); // To be overridden

    // Equip an item to a hand
    public void equip(Item item, boolean isLeftHand) {
        if (isLeftHand) leftHand = item;
        else rightHand = item;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void takeDamage(int damage) {
        health -= damage;
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    public List<Item> getInventory() {
        return Collections.unmodifiableList(inventory);
    }
}
