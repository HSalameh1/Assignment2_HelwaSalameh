//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

public class Game {
    public static void main(String[] args) {
        // Initialize chambers (exactly as specified in assignment PDF)
        Chamber[] chambers = new Chamber[] {
                new Chamber(),                      // Start
                new Chamber(new Axe()),             // Chamber with weapon
                new Chamber(new Shield()),          // Chamber with shield
                new Chamber(),                      // Empty chamber
                new Chamber()                       // Goal
        };

        // Connect chambers (with monsters as specified)
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Goblin", 1, 0, 3));
        Door.connect(chambers[2], chambers[3], new Monster("Spider", 3, 0, 5));
        Door.connect(chambers[3], chambers[4]);

        // Create player character
        Character player = new Wizard("Gandalf");

        // Initialize dungeon
        Dungeon dungeon = new Dungeon(player, chambers[0], chambers[4]);

        // Start game
        new TextUI().play(dungeon);
    }
}