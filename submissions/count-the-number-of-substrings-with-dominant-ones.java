class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans = 0;
        int[] map = new int[n + 1];
        for (int k = 0; k * (k + 1) <= n; ++k) {
            Arrays.fill(map, n);
            map[0] = -1;
            int countZ = 0;
            for (int i = 0; i < n; ++i) {
                countZ += s.charAt(i) == '0' ? 1 : 0;
                if (map[countZ] == n) map[countZ] = i;
                if (k == 0 && s.charAt(i) == '0') continue;
                if (countZ >= k) {
                    int left = map[countZ - k];
                    int right = map[countZ - k + 1];
                    int minLen = i - right + 1;
                    int maxLen = i - left;
                    int len = Math.max(1, k * (k + 1));
                    if (len <= minLen) ans += maxLen - minLen + 1;
                    else if (len <= maxLen) ans += maxLen - len + 1;
                }
            }
        }
        return ans;
    }
}