import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
public class PercolationStats {
    private final double[] totalTrials;
    private final double confidenceFactor = 1.96 ;
    private final double trialsSqrt ;
    public PercolationStats(int n, int trials){
        if(n <= 0 || trials <= 0)
            throw new IllegalArgumentException("N and trials must be greater than zero") ;
        // perform independent trials on an n-by-n grid
        this.trialsSqrt = Math.sqrt(trials) ;
        totalTrials = new double[trials] ;
        for(int i = 0; i < trials; i++){
            Percolation percolation = new Percolation(n) ;
            while(!percolation.percolates()){
                int x = StdRandom.uniformInt(1, n + 1);
                int y = StdRandom.uniformInt(1, n + 1);
                percolation.open(x,y);
            }
            double average = (double)percolation.numberOfOpenSites() / (double)(n*n) ;
            totalTrials[i] = average ;
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(totalTrials) ;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(totalTrials) ;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - (confidenceFactor*stddev() / trialsSqrt) ;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + (confidenceFactor*stddev() / trialsSqrt) ;
    }
}