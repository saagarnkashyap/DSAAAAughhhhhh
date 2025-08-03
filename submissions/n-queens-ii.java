class Solution {
    public int totalNQueens(int n) {
        return this.helper(new boolean[n * 2], new boolean[n * 2], new boolean[n], 0, n);
    }

    private int helper(final boolean[] diag1, final boolean[] diag2, final boolean[] col, final int row, final int n) {
        if(row == n)
            return 1;

        int result = 0;

        for(int i = 0; i < n; ++i) {
            if(!diag1[row + i] && !diag2[n - row + i] && !col[i]) {
                diag1[row + i] = true;
                diag2[n - row + i] = true;
                col[i] = true;

                result += this.helper(diag1, diag2, col, row + 1, n);

                diag1[row + i] = false;
                diag2[n - row + i] = false;
                col[i] = false;
            }
        }

        return result;
    }
}