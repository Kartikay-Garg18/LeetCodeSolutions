class Solution {
    public static void addPare(int n, int open, int close, String str, List<String> list){
        if (open == n && close==n){
            list.add(str);
            return;
        }
        if (open<n){
            addPare(n, open+1, close, str+"(", list);
        }
        if (close<open) {
            addPare(n, open, close + 1, str + ")", list);
        }
    }
    public static List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<>();
        addPare(n, 0, 0, "", list);
        return list;
    }
}
