class Solution {
    public int fun(int i, int j,boolean[][] vis, int[][] dp) {
        if (i < 0 || j < 0 || vis[i][j] == true) {
            return 0;
        }
        if(dp[i][j]!= -1){
            return dp[i][j];
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        int ans = 0;
        if (!vis[i][j]) {
            vis[i][j] = true;
            ans = fun(i - 1, j, vis,dp) + fun(i, j - 1, vis,dp);
            vis[i][j] =false;
        }
        return dp[i][j]= ans;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        boolean[][] vis = new boolean[m][n];
        return fun(m - 1, n - 1, vis,dp);
    }
}