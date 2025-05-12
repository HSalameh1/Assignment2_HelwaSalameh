//------------------------------------------------------
// Assignment 2
// Written by: Helwa Salameh [1961163]
// For SE 350 Section 630 – Spring 2025
//--------------------------------------------------------

/**
 * Handles error printing when user input fails
 */
public class PrintError extends Action {
    private final Exception exception;

    public PrintError(Dungeon dungeon, Exception exception) {
        super(dungeon);
        this.exception = exception;
    }

    @Override
    public void execute() {
        System.out.println("Error: " + exception.getMessage());
    }

    @Override
    public String toString() {
        return "Error occurred";
    }
}