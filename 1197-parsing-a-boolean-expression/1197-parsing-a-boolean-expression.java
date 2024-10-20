class Solution {
    class Pair{
        boolean b;
        int ind;
        public Pair(boolean b, int ind){
            this.b = b;
            this.ind = ind;
        }
    }

    public Pair findBoolean(String s, int idx, char op){
        if(s.charAt(idx) == 'f') return new Pair(false, idx+1);
        if(s.charAt(idx) == 't') return new Pair(true, idx+1);
        op = s.charAt(idx);
        idx+=2;
        boolean ans = false;
        switch(op){
            case '&':
                ans = true; 
                int i = idx;
                while(i<s.length()){
                    if(s.charAt(i)==','){
                        i++;
                        continue;
                    }
                    if(s.charAt(i) == ')') return new Pair(ans, i+1);
                    Pair p = findBoolean(s, i, op);
                    ans&=p.b;
                    i=p.ind;
                }
                break;
            case '|':
                i = idx;
                while(i<s.length()){
                    if(s.charAt(i)==','){
                        i++;
                        continue;
                    }
                    if(s.charAt(i) == ')') return new Pair(ans, i+1);
                    Pair p = findBoolean(s, i, op);
                    ans|=p.b;
                    i=p.ind;
                }
                break;
            case '!': 
                Pair p = findBoolean(s, idx, op);
                return new Pair(!p.b, p.ind+1);
        }
        return new Pair(ans, idx+1);
    }
    public boolean parseBoolExpr(String s) {
        return findBoolean(s, 0, '|').b;
    }
}