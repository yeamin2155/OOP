package ic8;

/**
 * Represents a star system in the Galactic Exploration Game.
 * Each star system has a type and a resource level.
 */
class StarSystem {
    private String systemType; // Type of the star system (e.g., Nebula, Binary Star)
    private String resourceLevel; // Level of resources in the star system (e.g., Abundant, Moderate)

    /**
     * Constructor: Creates a new star system with the specified type and resource level.
     * @param systemType The type of the star system.
     * @param resourceLevel The resource level of the star system.
     */
    public StarSystem(String systemType, String resourceLevel) {
        this.systemType = systemType;
        this.resourceLevel = resourceLevel;
    }

    // Getter methods to access the system type and resource level

    public String getSystemType() {
        return systemType;
    }

    public String getResourceLevel() {
        return resourceLevel;
    }

    /**
     * Converts the resource level to a numerical value for laser power calculation during Cosmic Clashes.
     * Higher resource levels contribute to higher laser power.
     * @return The numerical value representing the resource level.
     */
    public int getResourceValue() {
        switch (resourceLevel) {
            case "Abundant": return 4;
            case "Moderate": return 3;
            case "Scarce": return 2;
            case "Depleted": return 1;
            default: return 0; // Handle unexpected resource levels
        }
    }

    /**
     * Provides a string representation of the star system, including its type and resource level.
     * @return A formatted string describing the star system
     */
    @Override
    public String toString() {
        return systemType + " with " + resourceLevel + " resources";
    }
}