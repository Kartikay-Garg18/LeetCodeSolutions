class Solution {
    class Node{
        Node[] children;
        int vis;
        public Node(){
            children = new Node[26];
            vis = 1;
        }
    }
    private void insert(String word, Node root){
        for(int i=0; i<word.length(); i++){
            if(root.children[word.charAt(i) - 'a'] == null){
                root.children[word.charAt(i) - 'a'] = new Node();
            } else{
                root.children[word.charAt(i) - 'a'].vis++;
            }
            root = root.children[word.charAt(i) - 'a'];
        }
    }

    private int count(String word, Node root){
        int count = 0;
        for(int i=0; i<word.length(); i++){
            count+=root.children[word.charAt(i)-'a'].vis;
            root = root.children[word.charAt(i) - 'a'];
        }
        return count;
    }

    public int[] sumPrefixScores(String[] words) {
        Node root = new Node();
        for(String word : words){
            insert(word, root);
        }
        int[] ans = new int[words.length];
        for(int i=0; i<words.length; i++){
            ans[i] = count(words[i], root);
        }
        return ans;
    }
}