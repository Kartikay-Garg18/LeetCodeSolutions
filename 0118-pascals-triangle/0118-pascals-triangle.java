class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0; i<numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1; !list.isEmpty() && j<list.get(list.size()-1).size(); j++){
                temp.add(list.get(list.size()-1).get(j)+list.get(list.size()-1).get(j-1));
            }
            if(!list.isEmpty()) temp.add(1);
            list.add(new ArrayList<>(temp));
        }

        return list;
    }
}