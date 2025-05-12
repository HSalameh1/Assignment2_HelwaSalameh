//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Abstract base class for all player actions.
 */
public abstract class Action {
    protected final Dungeon dungeon;

    public Action(Dungeon dungeon) {
        this.dungeon = dungeon;
    }

    public abstract void execute();
    public abstract String toString();
}