package lab10;

public class Souvenir {
    private String name;
    private String description;
    private int hilarityLevel; // Add hilarityLevel

    // Constructor
    public Souvenir(String name, String description, int hilarityLevel) {
        this.name = name;
        this.description = description;
        this.hilarityLevel = hilarityLevel;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Getter for hilarityLevel
    public int getHilarityLevel() {
        return hilarityLevel;
    }
}
