class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            l3.val = sum%10;
            carry = sum/10;
            
            l1 = l1.next;
            l2 = l2.next;
            if(l1 != null || l2 != null || carry == 1)
                l3.next = new ListNode();
            l3 = l3.next;
            
        }
        if(l1 == null && l2 != null){
            // l3 = new ListNode();
            while(l2!=null){
                int sum = l2.val + carry;
                l3.val = sum%10;
                carry = sum/10;
                if(l2.next!=null || carry == 1)
                    l3.next = new ListNode();
                l2 = l2.next;
                l3 = l3.next;
                
            }
        }
        if(l2 == null && l1 != null){
            // l3 = new ListNode();
            while(l1!=null){
                int sum = l1.val + carry;
                l3.val = sum%10;
                carry = sum/10;
                if(l1.next != null || carry == 1)
                    l3.next = new ListNode();
                l1 = l1.next;
                l3 = l3.next;
                
            }
        }
        if(carry == 1){
            l3.val = carry;
        }
        return head;
    }
}
