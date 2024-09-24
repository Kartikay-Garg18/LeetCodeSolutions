class Solution {
    class Node{
        Node[] children;
        public Node(){
            children = new Node[10];
        }
    }

    public void insert(int num, Node root){
        int len = (int)Math.log10(num);
        while(len>=0){
            int power = (int)Math.pow(10, len);
            int q = num/power;
            num%=power;
            if(root.children[q] == null) root.children[q] = new Node();
            root = root.children[q];
            len--;
        }
    }

    public int search(int num, Node root){
        int len = (int)Math.log10(num);
        int count = 0;
        while(len>=0){
            int power = (int)Math.pow(10, len);
            int q = num/power;
            if(root.children[q] == null) return count;
            num%=power;
            count++;
            root = root.children[q];
            len--;
        }
        return count;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int max = 0;
        Node root = new Node();

        HashSet<Integer> set2 = new HashSet<>();
        for(int ele : arr2) set2.add(ele);

        HashSet<Integer> set1 = new HashSet<>();
        for(int ele : arr1) set1.add(ele);

        for(int ele : set2){
            insert(ele, root);
        }

        for(int ele : set1){
            max = Math.max(max, search(ele, root));
        }

        return max;
    }
}