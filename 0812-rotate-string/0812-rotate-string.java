class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        int n = s.length();

        for(int i=0; i<n; i++){
            String form = s.substring(i)+s.substring(0,i);
            if(form.equals(goal)) return true;
        }

        return false;
    }
}