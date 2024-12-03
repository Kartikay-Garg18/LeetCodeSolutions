class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<spaces.length; i++){
            int idx = spaces[i];
            sb.insert(idx+i, " ");
        }
        return sb.toString();
    }
}