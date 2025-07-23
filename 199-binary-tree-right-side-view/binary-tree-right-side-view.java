/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//DFS beats 100%
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }

    void helper(TreeNode root, int level, List<Integer> ans ){
        if (root == null) return;
        if (ans.size() == level){
            //this level is visited first time 
            ans.add(root.val);
        }
        helper(root.right, level+1, ans); //for right view always ensure to visit right first
        helper(root.left, level+1, ans);
    }
}


// refer to this once again maybe tom.... 
//bfs makes 71% beats so ensure you use dfs 

// dfs over bfs

// class Solution {
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if (root == null) return ans;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.offer(root);

//         while (!q.isEmpty()){
//             int n = q.size();
//             for (int i=0;i<n;i++){
//                 TreeNode node = q.poll();
//                 if (i==n-1){
//                     ans.add(node.val); //update ans on last node of level
//                 }
//                 if (node.left != null){
//                     q.offer(node.left);
//                 }
//                 if (node.right != null){
//                     q.offer(node.right);
//                 }
//             }
//         }
//         return ans;
//     }
// }
