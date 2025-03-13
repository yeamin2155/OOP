// In-Class 10 – COSC 2425-<your section number> – Professor McCurry
// Implemented by: Ashabul Yeamin

package ic10;

public class AstronautIC10 {
    private String name;
    private int score;
    
    // Constructor
    public AstronautIC10(String name, int score) {
        this.name = name;
        this.score = score;
    }
    
    // toString method to display 
    @Override
    public String toString() {
        return "Astronaut: " + name + ", Score: " + score;
    }
    
    // equal method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AstronautIC10 other = (AstronautIC10) obj;
        return name.equals(other.name) && score == other.score;
    }
}
