package lab10;

public class CruiseChaos {
    public static void main(String[] args) {
        // Create a suitcase object
        Suitcase suitcase = new Suitcase();

        // Add souvenirs
        Souvenir s1 = new Souvenir("Pocket Black Hole Generator", 
            "Don't worry, it's only a miniature one... probably.", 9);
        Souvenir s2 = new Souvenir("Self-Combusting Hairpiece", 
            "For the distinguished alien gentleman with a flair for the dramatic.", 7);
        Souvenir s3 = new Souvenir("Jar of Space Pickles", 
            "They glow in the dark! And probably taste a bit like feet.", 5);

        suitcase.addSouvenir(s1);
        suitcase.addSouvenir(s2);
        suitcase.addSouvenir(s3);

        // Display all souvenirs
        System.out.println("Displaying all souvenirs:");
        suitcase.displaySouvenirs();

        // Total hilarity level
        System.out.println("\nTotal Hilarity Level: " + suitcase.totalHilarity());

        // Find a souvenir
        System.out.println("\nSearching for 'Self-Combusting Hairpiece': " +
            (suitcase.findSouvenir(s2) ? "Found!" : "Not Found!"));

        // Remove a souvenir
        System.out.println("\nRemoving 'Jar of Space Pickles'.");
        suitcase.removeSouvenir(s3);

        // Display all souvenirs after removal
        System.out.println("\nDisplaying all souvenirs after removal:");
        suitcase.displaySouvenirs();
    }
}
