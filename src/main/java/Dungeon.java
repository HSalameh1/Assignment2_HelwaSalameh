//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import java.util.ArrayList;
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

    public Character getPlayer() {
        return player;
    }

    public void setCurrentChamber(Chamber chamber) {
        this.currentChamber = chamber;
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        Chamber current = getCurrentChamber();

        // Movement (only for unlocked doors)
        for (Door door : current.getDoors()) {
            if (door.isUnlocked()) {
                actions.add(new Move(this, door));
            }
        }

        // Combat (only for alive monsters)
        current.getDoors().stream()
                .filter(door -> door.getGuard() != null && !door.isUnlocked())
                .forEach(door -> actions.add(new Fight(this, door.getGuard())));

        // Item pickup
        current.getItems().forEach(item ->
                actions.add(new Pick(this, item)));

        return actions;
    }
}
