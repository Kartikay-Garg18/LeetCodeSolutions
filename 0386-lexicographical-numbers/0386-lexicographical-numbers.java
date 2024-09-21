class Solution {
    public static void helper(int n, int ans, List<Integer> list) {
        if (ans > n) {
            return;
        }
        list.add(ans);
        helper(n, ans * 10, list);
        if (ans % 10 != 9) {
            helper(n, ans + 1, list);
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        helper(n, 1, list);
        return list;
    }
}