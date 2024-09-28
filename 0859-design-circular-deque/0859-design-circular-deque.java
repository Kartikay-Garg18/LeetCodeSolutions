class MyCircularDeque {
    class Node{
        Node prev;
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    int size=0;
    int capacity;
    Node head;
    Node tail;

    public MyCircularDeque(int k) {
        capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size>=capacity){
            return false;
        }
        if(head==null){
            head = tail = new Node(value);
        } else{
            head.prev = new Node(value);
            head.prev.next = head;
            head = head.prev;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size>=capacity){
            return false;
        }
        if(head==null){
            head = tail = new Node(value);
        } else{
            tail.next = new Node(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        head = head.next;
        if(head == tail && head!=null){
            head.prev = null;
        }
        if(head==null) tail=null;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        tail = tail.prev;
        if(tail!=null) tail.next = null;
        size--;
        if(tail == null) head=null;
        return true;
    }
    
    public int getFront() {
        if(size<=0) return -1;
        return head.data;
    }
    
    public int getRear() {
        if(size<=0) return -1;
        return tail.data;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */