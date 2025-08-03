public class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int maxIndex = -1;
        int secondMax = Integer.MIN_VALUE;
        System.out.println("Saagar N Kashyap, 22BCE8600");
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                secondMax = maxNum;
                maxNum = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (maxNum < secondMax * 2) {
            return -1;
        }
        return maxIndex;
    }
}