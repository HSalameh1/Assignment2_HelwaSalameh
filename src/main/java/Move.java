//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Moves the player through a door to another chamber.
 */
public class Move extends Action {
    private final Door door;

    public Move(Dungeon dungeon, Door door) {
        super(dungeon);
        this.door = door;
    }

    @Override
    public void execute() {
        Chamber current = dungeon.getCurrentChamber();
        Chamber next = door.getOtherChamber(current);

        if (door.getGuard() == null) {
            dungeon.setCurrentChamber(next);
            System.out.println("Moved to next chamber!");
        } else {
            System.out.println("Door is guarded by " + door.getGuard().getName());
        }
    }

    @Override
    public String toString() {
        return "Move through door";
    }
}