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

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        Chamber current = getCurrentChamber();

        // Add movement actions
        for (Door door : current.getDoors()) {
            actions.add(new Move(this, door));
        }

        // Add fight actions for guarded doors
        current.getDoors().stream()
                .filter(door -> door.getGuard() != null)
                .forEach(door -> actions.add(new Fight(this, door.getGuard())));

        // Add item pickup actions
        current.getItems().forEach(item ->
                actions.add(new Pick(this, item)));

        return actions;
    }
}
