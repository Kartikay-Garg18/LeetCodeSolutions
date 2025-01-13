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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        
        ListNode prevNode = head;
        ListNode currNode = head.next;
        while(currNode != null){
            if(prevNode.val==currNode.val){
                prevNode.next = null;
                currNode = currNode.next;
            } else{
                prevNode.next = currNode;
                prevNode = prevNode.next;
                currNode = currNode.next;
            }
        }
        return head;
    }
}