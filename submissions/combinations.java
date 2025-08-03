class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();

        backtrack(n, k, 1, currentCombination, result);

        return result;
    }

    private static void backtrack(int n, int k, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (currentCombination.size() == k) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(n, k, i + 1, currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}