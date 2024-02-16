class Solution {
    public static String[] keypad = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void helper(String str, int ind, String combination, List<String> list){
        if(ind == str.length()){
            list.add(combination);
            return;
        }
        char currChar = str.charAt(ind);
        String mapping = keypad[currChar-'1'];
        for (int i=0; i<mapping.length(); i++){
            helper(str, ind+1, combination+mapping.charAt(i), list);
        }
    }
    public static List<String> letterCombinations(String str){
        List<String> list = new ArrayList<>();
        if(str.length()==0){
            return list;
        }
        helper(str, 0, "", list);
        return list;
    }
}
