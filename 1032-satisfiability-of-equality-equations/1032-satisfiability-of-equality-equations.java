class Solution {
    private char find(char[] parent, char x) {
        if(parent[x-'a'] == x) return x;
        return parent[x-'a'] = find(parent, parent[x-'a']);
    }

    private void union(char[] parent, char f, char s){
        char px = find(parent, f);
        char py = find(parent, s);
        if(px!=py){
            parent[py-'a'] = px;
        }
    }

    private boolean check(char[] parent, char f, char s){
        char px = find(parent, f);
        char py = find(parent, s);
        if(px == py) return true;
        return false;
    }

    public boolean equationsPossible(String[] equations) {
        char[] parent = new char[26];
        for(int i=0; i<26; i++){
            parent[i] = (char)(i+'a');
        }

        for(String eq : equations){
            char f = eq.charAt(0);
            char s = eq.charAt(3);
            if(eq.charAt(1) == '='){
                union(parent, f, s);
            }
        }
        
        for(String eq : equations){
            char f = eq.charAt(0);
            char s = eq.charAt(3);
            if(eq.charAt(1) != '='){
                if(check(parent, f, s)){
                    return false;
                }
            }
        }
        return true;
    }
}