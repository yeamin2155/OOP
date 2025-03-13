package asg7;

public class AlienCommunicationDriver {
    public static void main(String[] args) {
        // Create a BioLuminescentGrid
        BioLuminescentGrid grid = new BioLuminescentGrid(5, 5);
        grid.setLight(0, 0, true);
        grid.setLight(0, 1, true);
        grid.setLight(0, 2, true);
        grid.setLight(1, 2, true);
        grid.setLight(2, 2, true);

        // Create a XenoLexicon
        XenoLexicon lexicon = new XenoLexicon();
        lexicon.addWord("111");
        lexicon.addWord("10101");
        lexicon.addWord("11100");

        // Create an AlienCommunicationDecoder
        AlienCommunicationDecoder decoder = new AlienCommunicationDecoder();

        // Display the grid
        System.out.println("BioLuminescent Grid:");
        grid.displayGrid();

        // Decode and display the results
        boolean found = decoder.search(grid, lexicon);
        System.out.println("\nWord found in the grid: " + found);
    }
}
