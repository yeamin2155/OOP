package asg7;

public class AlienCommunicationDecoder {
    public boolean search(BioLuminescentGrid grid, XenoLexicon lexicon) {
        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getCols(); col++) {
                if (searchRecursive(grid, lexicon, row, col, new StringBuilder(), 0, 0, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchRecursive(BioLuminescentGrid grid, XenoLexicon lexicon, int row, int col, StringBuilder currentWord, int rowIncrement, int colIncrement, int currentIndex) {
        // Base Case
        if (row < 0 || row >= grid.getRows() || col < 0 || col >= grid.getCols() || !grid.isLightOn(row, col)) {
            return false;
        }

        currentWord.append("1");
        if (lexicon.isWord(currentWord.toString())) {
            return true;
        }

        boolean found = false;
        for (int[] direction : new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {-1,-1}, {1,-1}, {-1,1}}) {
            found = found || searchRecursive(grid, lexicon, row + direction[0], col + direction[1], new StringBuilder(currentWord), direction[0], direction[1], currentIndex + 1);
        }

        return found;
    }
}
