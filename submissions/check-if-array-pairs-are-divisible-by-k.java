import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderCount = new HashMap<>();
        for (int num : arr) {
            int remainder = (num % k + k) % k;
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        if (remainderCount.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        for (int i = 1; i <= k / 2; i++) {
            int count1 = remainderCount.getOrDefault(i, 0);
            int count2 = remainderCount.getOrDefault(k - i, 0);
            if (count1 != count2) {
                return false;
            }
        }

        if (k % 2 == 0) {
            int count = remainderCount.getOrDefault(k / 2, 0);
            if (count % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}