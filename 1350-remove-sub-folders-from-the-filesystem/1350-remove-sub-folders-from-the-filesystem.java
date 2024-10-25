class Solution {
    private boolean check(String orig, String news){
        String[] origArr = orig.split("/");
        String[] newArr = news.split("/");
        for(int i=1; i<origArr.length; i++){
            if(!(origArr[i].equals(newArr[i]))) return true;
        }
        return false;
    }
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        Stack<String> stk = new Stack<>();
        for(String str : folder){
            if(!stk.isEmpty() && !check(stk.peek(), str)){
                continue;
            }
            stk.push(str);
        }

        List<String> ans = new ArrayList<>();
        while(!stk.isEmpty()) ans.add(stk.pop());
        return ans;
    }
}