//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Abstract base class for all items (weapons, shields, etc.).
 * Items can be equipped by characters to modify stats.
 */
public abstract class Item {
    private String name;
    private int strengthBonus;
    private int craftBonus;

    public Item(String name, int strengthBonus, int craftBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.craftBonus = craftBonus;
    }

    // Getters
    public String getName() { return name; }
    public int getStrengthBonus() { return strengthBonus; }
    public int getCraftBonus() { return craftBonus; }

    @Override
    public String toString() {
        return name + " (STR+" + strengthBonus + ", CRT+" + craftBonus + ")";
    }
}
