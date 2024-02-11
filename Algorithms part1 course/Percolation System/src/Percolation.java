import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final boolean[][] grid;
    private final WeightedQuickUnionUF wqufGrid;
    private final WeightedQuickUnionUF wqufFull;
    private final int gridSize;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites;
    private final int[][] neighbors = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Enter number greater than 0");
        }

        this.gridSize = n;
        this.grid = new boolean[gridSize][gridSize];
        this.wqufGrid = new WeightedQuickUnionUF(gridSize * gridSize + 2); // includes virtual top and bottom
        this.wqufFull = new WeightedQuickUnionUF(gridSize * gridSize + 1); // includes virtual top
        this.virtualTop = gridSize * gridSize;
        this.virtualBottom = gridSize * gridSize + 1;
        this.openSites = 0;
    }

    private int getEquivalentFlattenedNumber(int row, int col) {
        validateSite(row, col);
        return gridSize * (row - 1) + col ;
    }

    private boolean isOnGrid(int row, int col) {
        row-- ;
        col-- ;
        return row >= 0 && col >= 0 && row < gridSize && col < gridSize;
    }
    private void validateSite(int row, int col) {
        if (!isOnGrid(row, col)) {
            throw new IndexOutOfBoundsException("Site (" + row + ", " + col + ") is out of bounds");
        }
    }

    // Test: open site (row, col) if it is not open already
    public void open(int row, int col) {
        validateSite(row, col);

        int updatedRow = row - 1;
        int updatedCol = col - 1;
        int flatIndex = getEquivalentFlattenedNumber(row, col) - 1;

        // If already open, stop
        if (isOpen(row, col)) {
            return;
        }
        // Open Site
        grid[updatedRow][updatedCol] = true;
        openSites++;

        if (row == 1) {  // Top Row
            wqufGrid.union(virtualTop, flatIndex);
            wqufFull.union(virtualTop, flatIndex);
        }

        if (row == gridSize) {  // Bottom Row
            wqufGrid.union(virtualBottom, flatIndex);
        }


        for (int[] neighbor : neighbors) {
            int r = row + neighbor[0];
            int c = col + neighbor[1];

            if (isOnGrid(r, c) && isOpen(r, c)) {
                int neighborIndex = getEquivalentFlattenedNumber(r, c) - 1;
                wqufGrid.union(flatIndex, neighborIndex);
                wqufFull.union(flatIndex, neighborIndex);
            }
        }
    }


    // Test: is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateSite(row, col);
        return grid[row - 1][col - 1];
    }

    // Test: is site (row, col) full?
    public boolean isFull(int row, int col) {
        validateSite(row, col);
        return wqufFull.connected(virtualTop, getEquivalentFlattenedNumber(row, col) - 1);
    }

    // Test: number of open sites
    public int numberOfOpenSites() {
        return openSites;
    }

    // Test: does the system percolate?
    public boolean percolates() {
        return wqufGrid.connected(virtualTop, virtualBottom);
    }

}