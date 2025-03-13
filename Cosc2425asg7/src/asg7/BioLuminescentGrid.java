package asg7;

public class BioLuminescentGrid {
    private boolean[][] grid;

    public BioLuminescentGrid(int rows, int cols) {
        grid = new boolean[rows][cols];
    }

    public boolean isLightOn(int row, int col) {
        return grid[row][col];
    }

    public void setLight(int row, int col, boolean state) {
        grid[row][col] = state;
    }

    public void displayGrid() {
        for (boolean[] row : grid) {
            for (boolean light : row) {
                System.out.print(light ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }
}
