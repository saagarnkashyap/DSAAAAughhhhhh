class Solution {
    public int maxSum(int[][] grid) {
        int lastRow = grid.length - 1;
        int lastCol = grid[0].length - 1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < lastRow; i++) {
			for (int j = 1; j < lastCol; j++) {
				int sum = grid[i][j] + grid[i-1][j] + grid[i+1][j] + grid[i-1][j-1] + grid[i-1][j+1] + grid[i+1][j-1] + grid[i+1][j+1] ;
				max = Math.max(max, sum);
			}
		}
        return max;
    }
}