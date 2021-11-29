package hw2;

public class PercolationStats {
    private int T;
    private int N;
    private Percolation[] perc;
    private double[] th;
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0){
            throw new java.lang.IllegalArgumentException();
        }
        this.T = T;
        this.N = N;
        perc = new Percolation[T];
        th = new double[T];
        for(int i = 0; i < T; i++) {
            perc[i] = pf.make(N);
            while (!perc[i].percolates()){
                perc[i].open(edu.princeton.cs.introcs.StdRandom.uniform(N), edu.princeton.cs.introcs.StdRandom.uniform(N));
            }
            th[i] = perc[i].numberOfOpenSites() * 1.0 / (N * N);
        }
    }
    // perform T independent experiments on an N-by-N grid
    public double mean() {
//        double sum = 0.0;
//        for(int i = 0; i < T; i++){
//            sum += (perc[i].numberOfOpenSites() * 1.0) / (N * N);
//        }
//        return sum / T;
        return edu.princeton.cs.introcs.StdStats.mean(th);
    }
    // sample mean of percolation threshold
    public double stddev() {
        return edu.princeton.cs.introcs.StdStats.stddev(th);
//        double mean = mean();
//        double sum = 0.0;
//        for (int i = 0; i < T; i++){
//            sum += Math.pow((perc[i].numberOfOpenSites() * 1.0) / (N * N) - mean, 2);
//        }
//        return sum / (T - 1);
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
//    public static void main(String[] args) {
//        PercolationFactory pf = new PercolationFactory();
//        PercolationStats ps = new PercolationStats(50, 40, pf);
//        System.out.println(ps.mean());
//    }
}
