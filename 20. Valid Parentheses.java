class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if(s.length()==1 || s.charAt(0)==')' || s.charAt(0)=='}' || s.charAt(0)==']'){
            return false;
        }
        while(!s.isEmpty()){
                if (s.charAt(0) == '(' || s.charAt(0) == '[' || s.charAt(0) == '{') {
                    stk.push(s.charAt(0));
                    s = s.substring(1);
                } else if (s.charAt(0) == ')') {
                    if (stk.isEmpty() || '(' != stk.pop()) {
                        return false;
                    } else{
                        s = s.substring(1);
                    }
                } else if (s.charAt(0) == ']') {
                    if (stk.isEmpty() || stk.pop() != '[') {
                        return false;
                    } else{
                        s = s.substring(1);
                    }
                } else if (s.charAt(0) == '}'){
                    if (stk.isEmpty() || stk.pop() != '{') {
                        return false;
                    } else{
                        s = s.substring(1);
                    }
                }

            }
            if(!stk.isEmpty()){
                return false;
            }
            return true;
    }
}
