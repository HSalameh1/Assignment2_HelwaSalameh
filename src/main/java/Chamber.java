//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a room in the dungeon containing doors and items.
 */
public class Chamber {
    private final List<Door> doors;
    private final List<Item> items;

    public Chamber() {
        this.doors = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Chamber(Item item) {
        this();
        this.items.add(item);
    }

    // Add a door to this chamber
    public void addDoor(Door door) {
        doors.add(door);
    }

    // Add an item to this chamber
    public void addItem(Item item) {
        items.add(item);
    }

    // Getters
    public List<Door> getDoors() {
        return doors;
    }

    public List<Item> getItems() {
        return items;
    }
}
