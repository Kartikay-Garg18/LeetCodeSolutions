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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null){
            return null;
        }
        int length = 0;
        ListNode currNode = head;
        while (currNode!= null){
            length++;
            currNode = currNode.next;
        }
        if(length == n){
            return head.next;
        }
        currNode = head;
        int counter = 0;
        while(counter<(length-n-1)){
            counter++;
            currNode = currNode.next;
        }
        if(currNode.next.next!= null){
            currNode.next = currNode.next.next;
        } else{
            currNode.next = null;
        }
        return head;
    }
}
