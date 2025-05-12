//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Handles combat between player and a monster.
 */
public class Fight extends Action {
    private final Monster monster;

    public Fight(Dungeon dungeon, Monster monster) {
        super(dungeon);
        this.monster = monster;
    }

    @Override
    public void execute() {
        Character player = dungeon.getPlayer();
        int playerAttack = player.attack(monster);
        int monsterAttack = monster.attack(player);

        monster.takeDamage(playerAttack);
        player.takeDamage(monsterAttack);

        if (monster.isDefeated()) {
            dungeon.getCurrentChamber().getDoors().stream()
                    .filter(door -> door.getGuard() == monster)
                    .findFirst()
                    .ifPresent(Door::removeGuard);
        }
    }

    @Override
    public String toString() {
        return "Fight " + monster.getName();
    }
}