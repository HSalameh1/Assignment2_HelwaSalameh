//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Picks up an item from the current chamber.
 */
public class Pick extends Action {
    private final Item item;

    public Pick(Dungeon dungeon, Item item) {
        super(dungeon);
        this.item = item;
    }

    @Override
    public void execute() {
        dungeon.getPlayer().addToInventory(item);
        dungeon.getCurrentChamber().getItems().remove(item);
        System.out.println("Picked up: " + item.getName());
    }

    @Override
    public String toString() {
        return "Pick up " + item.getName();
    }
}