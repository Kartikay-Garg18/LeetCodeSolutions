class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length()<s.length()) return false;
        s+=s;
        return s.contains(goal);
    }
}