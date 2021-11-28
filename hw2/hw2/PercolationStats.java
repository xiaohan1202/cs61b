package hw2;

public class PercolationStats {
    int T;
    int N;
    Percolation[] perc = new Percolation[T];
    public PercolationStats(int N, int T, PercolationFactory pf) {
        this.T = T;
        this.N = N;
        for(int i = 0; i < T; i++) {
            perc[i] = pf.make(N);
        }
    }
    // perform T independent experiments on an N-by-N grid
    public double mean() {
        double sum = 0.0;
        for(int i = 0; i < T; i++){
            if(perc[i].percolates()){
                sum += perc[i].numberOfOpenSites() * 1.0 / N * N;
            }
        }
        return sum / T;
    }
    // sample mean of percolation threshold
    public double stddev() {
        double mean = mean();
        double sum = 0.0;
        for (int i = 0; i < T; i++){
            if(perc[i].percolates()){
                sum += Math.pow(perc[i].numberOfOpenSites() * 1.0 / N * N - mean, 2);
            }
        }
        return sum / (T - 1);
    }
    // sample standard deviation of percolation threshold
    public double confidenceLow() {
        return mean() - 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }
    // low endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + 1.96 * Math.sqrt(stddev()) / Math.sqrt(T);
    }
    // high endpoint of 95% confidence interval
}
