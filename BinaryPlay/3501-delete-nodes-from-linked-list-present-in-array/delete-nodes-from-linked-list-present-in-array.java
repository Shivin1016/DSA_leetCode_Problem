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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // store num of nums in hashSet
        Set<Integer> st = new HashSet<>();
        for(int num : nums) st.add(num);

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            int val = curr.val; 
            if(st.contains(val)){
                ListNode temp = curr;
                if(prev == null){
                    //starting node ==> prev == null
                    curr = curr.next;
                    head = curr;
                    temp.next = null;
                }else if(curr.next == null){
                    //last node 
                    prev.next = null;
                    curr = null;
                }else{
                    //middle node
                    prev.next = curr.next;
                    curr = prev.next;
                } 
            }else{
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}