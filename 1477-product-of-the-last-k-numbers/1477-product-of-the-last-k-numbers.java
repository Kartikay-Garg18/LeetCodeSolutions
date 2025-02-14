class ProductOfNumbers {
    ArrayList<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
        list.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>();
            list.add(1);
            return;
        }
        list.add(num*list.getLast());
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(k>n-1){
            return 0;
        }
        return list.getLast()/list.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 0 0
 */