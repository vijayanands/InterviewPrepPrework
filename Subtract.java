/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        if (A == null) return null;
        int listLength = 0;
        ListNode tmp = A;
        ListNode tail = null;
        while (tmp != null) {
            listLength++;
            tail = tmp;
            tmp = tmp.next;
        }
        tail.next = A;
        int middleNode = listLength/2;
        
        ListNode tmp1 = A;
        ListNode tmp2 = tail;
        for (int i = 0 ; i < middleNode; i++) {
            tmp1.val = tmp2.val -  tmp1.val;
            tmp1 = tmp1.next;
            for (int j = 0; j < listLength-1; j++) {
                tmp2 = tmp2.next;
            }
        }
        tail.next = null;
        return A;
    }
}
