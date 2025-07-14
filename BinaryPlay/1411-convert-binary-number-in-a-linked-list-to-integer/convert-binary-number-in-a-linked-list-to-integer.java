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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;

        //finding length of the LinkedList--->for calculating each power value 
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        } 

        temp = head; 
        int power = len - 1;
        int num = 0;

        while(temp != null){
            if(temp.val == 1){
                int value = (int)Math.pow(2 , power); 
                num += value;
            }
            power--;
            temp = temp.next;
        }
        return num;
    }
}