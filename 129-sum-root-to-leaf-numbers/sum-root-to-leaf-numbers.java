class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,"");
    }

    public int helper(TreeNode root,String s)
    {
        if(root== null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return Integer.parseInt(s+root.val);
        }

        int left=helper(root.left,s+root.val);
        int right=helper(root.right,s+root.val);

        return left+right;

    }
}