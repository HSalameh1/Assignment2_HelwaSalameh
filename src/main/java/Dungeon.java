//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import java.util.List;

/**
 * Manages the dungeon state and player progress.
 */
public class Dungeon {
    private final Character player;
    private Chamber currentChamber;
    private final Chamber goalChamber;

    public Dungeon(Character player, Chamber start, Chamber goal) {
        this.player = player;
        this.currentChamber = start;
        this.goalChamber = goal;
    }

    public boolean isFinished() {
        return player.getHealth() <= 0 || currentChamber == goalChamber;
    }

    public Chamber getCurrentChamber() {
        return currentChamber;
    }

    public List<Action> getActions() {
        // TODO: Implement based on current chamber state
        return List.of();
    }
}
