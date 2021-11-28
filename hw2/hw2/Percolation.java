package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private Boolean[][] grid;
    private int opennum = 0;
    private int N;
    WeightedQuickUnionUF wqu;
    public Percolation(int N) {
        this.N = N;
        wqu = new WeightedQuickUnionUF(N * N + 2);
        grid = new Boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                grid[i][j] = false;
            }
        }
        for (int i = 0; i < N; i++) {
            wqu.union(0, xyTo1D(0, i));
            wqu.union(N * N + 1, xyTo1D(N - 1, i));
        }
    }
    // create N-by-N grid, with all sites initially blocked
    private int xyTo1D (int x, int y){
        return N * y + x;
    }
    public void open(int row, int col) {
        grid[row][col] = true;
        unionSite(row, col);
        opennum += 1;
    }
    private void unionSite(int row, int col){
        if(row != N - 1){
            if(isOpen(row + 1, col)){
                wqu.union(xyTo1D(row, col), xyTo1D(row + 1, col));
            }
        }
       if(row != 0){
           if(isOpen(row - 1, col)){
               wqu.union(xyTo1D(row, col), xyTo1D(row - 1, col));
           }
       }
       if(col != N - 1){
           if(isOpen(row, col + 1)){
               wqu.union(xyTo1D(row, col), xyTo1D(row, col + 1));
           }
       }
       if(col != 0) {
           if(isOpen(row, col - 1) && col != 0){
               wqu.union(xyTo1D(row, col), xyTo1D(row, col - 1));
           }
       }

    }
    // open the site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        return grid[row][col];
    } // is the site (row, col) open?
    public boolean isFull(int row, int col) {
        return wqu.connected(0, xyTo1D(row, col)) && isOpen(row, col);
    }
    // is the site (row, col) full?
    public int numberOfOpenSites() {
        return opennum;
    }
    // number of open sites
    public boolean percolates() {
        return wqu.connected(0, N * N + 1);
    }
    // does the system percolate?
//    public static void main(String[] args)   // use for unit testing (not required)
}
