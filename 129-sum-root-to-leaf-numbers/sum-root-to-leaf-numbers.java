class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    // DFS traversal with accumulated number
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recurse on both subtrees
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
