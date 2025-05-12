//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Connects two chambers and can be guarded by a monster.
 */
public class Door {
    private final Chamber chamber1;
    private final Chamber chamber2;
    private Monster guard;

    private Door(Chamber chamber1, Chamber chamber2, Monster guard) {
        this.chamber1 = chamber1;
        this.chamber2 = chamber2;
        this.guard = guard;
    }

    /**
     * Static factory method to connect two chambers.
     */
    public static void connect(Chamber c1, Chamber c2, Monster guard) {
        Door door = new Door(c1, c2, guard);
        c1.addDoor(door);
        c2.addDoor(door);
    }

    // Overloaded for unguarded doors
    public static void connect(Chamber c1, Chamber c2) {
        connect(c1, c2, null);
    }

    // Getters
    public Monster getGuard() {
        return guard;
    }

    public Chamber getOtherChamber(Chamber current) {
        return current == chamber1 ? chamber2 : chamber1;
    }

    public void removeGuard() {
        this.guard = null;
    }
}
