class Solution {
    public double new21Game(int N, int K, int maxPts) {
        if (K == 0 || N >= K - 1 + maxPts) return 1.0;

        double[] dp = new double[N + 1];
        dp[0] = 1.0;
        double sum = dp[0];
        double probability = 0.0;

        for (int i = 1; i <= N; i++) {
            dp[i] = sum / maxPts;
            if (i < K) sum += dp[i];
            else probability += dp[i];
            if (i >= maxPts) sum -= dp[i - maxPts];
        }

        return probability;
    }
}