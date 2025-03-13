package lab10;

import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Souvenir> souvenirs; // List to store souvenirs

    // Constructor
    public Suitcase() {
        this.souvenirs = new ArrayList<>();
    }

    // Add a souvenir
    public void addSouvenir(Souvenir souvenir) {
        souvenirs.add(souvenir);
    }

    // Remove a souvenir
    public void removeSouvenir(Souvenir souvenir) {
        souvenirs.remove(souvenir);
    }

    // Find a souvenir
    public boolean findSouvenir(Souvenir souvenir) {
        return souvenirs.contains(souvenir);
    }

    // Display all souvenirs
    public void displaySouvenirs() {
        for (Souvenir souvenir : souvenirs) {
            System.out.println("Name: " + souvenir.getName() + 
                ", Hilarity Level: " + souvenir.getHilarityLevel());
        }
    }

    // Calculate total hilarity level
    public int totalHilarity() {
        int total = 0;
        for (Souvenir souvenir : souvenirs) {
            total += souvenir.getHilarityLevel();
        }
        return total;
    }
}
