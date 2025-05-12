//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TextUI {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void play(Dungeon d) {
        System.out.println("=== Dungeon Adventure ===");
        System.out.println("Welcome, " + d.getPlayer().getName() + "!\n");

        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }

        // Game end message
        if (d.getPlayer().getHealth() <= 0) {
            System.out.println("\nGame Over! You were defeated...");
        } else {
            System.out.println("\nCongratulations! You escaped the dungeon!");
        }
    }

    /** Print the current room of the dungeon. */
    private void print(Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();

        // Player status
        s.append("\n--------------------------------\n");
        s.append(d.getPlayer().getName() + "'s Status:\n");
        s.append("Health: ").append(d.getPlayer().getHealth()).append("\n");
        s.append("Strength: ").append(d.getPlayer().getStrength()).append("\n");
        s.append("Craft: ").append(d.getPlayer().getCraft()).append("\n");

        // Chamber description
        s.append("\nYou are in a chamber with ").append(r.getDoors().size()).append(" doors\n");

        // Print items
        if (r.getItems().isEmpty()) {
            s.append("No items in this chamber.\n");
        } else {
            s.append("Items here:\n");
            for (Item item : r.getItems()) {
                s.append("- ").append(item.toString()).append("\n");
            }
        }

        // Print door info
        s.append("\nDoors:\n");
        List<Door> doors = r.getDoors();
        for (int i = 0; i < doors.size(); i++) {
            Door door = doors.get(i);
            s.append(i+1).append(". ");
            if (door.getGuard() != null) {
                Monster m = door.getGuard();
                s.append("Guarded by ").append(m.getName())
                        .append(" (HP:").append(m.getHealth())
                        .append(m.getStrength() > 0 ? " STR:" + m.getStrength() : " CRT:" + m.getCraft())
                        .append(")\n");
            } else {
                s.append("Unlocked door\n");
            }
        }
        s.append("--------------------------------");
        System.out.println(s.toString());
    }

    /** Asks the user for an action. */
    private Action ask(Dungeon d) {
        List<Action> actions = d.getActions();

        while (true) {
            try {
                System.out.println("\nAvailable actions:");
                for (int i = 0; i < actions.size(); i++) {
                    System.out.printf("%d. %s\n", i, actions.get(i).toString());
                }
                System.out.print("Choose an action (0-" + (actions.size()-1) + "): ");

                int command = Integer.parseInt(reader.readLine());
                if (command >= 0 && command < actions.size()) {
                    return actions.get(command);
                }
                System.out.println("Invalid number! Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number!");
            } catch (IOException e) {
                System.out.println("Input error! Try again.");
                return new PrintError(d, e);
            }
        }
    }
}