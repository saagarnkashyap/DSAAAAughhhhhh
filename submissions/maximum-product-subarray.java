class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int suffix=1;
        int ans=nums[0];
        int n=nums.length;
        double mm=1e9;
        for (int i=0;i<n;i++){
            prefix=prefix==0 ? 1:prefix;
            suffix=suffix==0?1:suffix;
            prefix=prefix*nums[i];
            suffix=suffix*nums[n-i-1];
            ans=(int)Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }
}