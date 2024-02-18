/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode list3 = new ListNode();
        ListNode head = list3;
        while(list1!=null && list2!=null){
            if(list1.val == list2.val){
                list3.val = list1.val;
                list1 = list1.next;
                list3.next = new ListNode();
                list3 = list3.next;
                list3.val = list2.val;
                list2 = list2.next;
                if(list1 != null || list2 != null){
                    list3.next = new ListNode();
                }
                list3 = list3.next;
            } else if(list1.val<list2.val){
                list3.val = list1.val;
                list3.next = new ListNode();
                list1 = list1.next;
                list3 = list3.next;
            } else{
                list3.val = list2.val;
                list3.next = new ListNode();
                list2 = list2.next;
                list3 = list3.next;
            }
        }
        if(list1==null && list2!=null){
            while(list2!=null){
                list3.val = list2.val;
                list2 = list2.next;
                if(list2!=null){
                    list3.next = new ListNode();
                }
                list3 = list3.next;
            }
        }
        if(list2==null && list1!=null){
            while(list1!=null){
                list3.val = list1.val;
                list1 = list1.next;
                if(list1!=null){
                    list3.next = new ListNode();
                }
                list3 = list3.next;
            }
        }
        return head;
    }
}
