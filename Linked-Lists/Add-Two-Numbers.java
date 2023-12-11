// imp thing here is there could be carry and no elementsin l1 & l2 8+7, so need to run while even if carry is 1
/*
2. Add Two Numbers : LeetCode

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

-----------------------------------------------------------------------------------------------------------

Solution: */

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode answerList= new ListNode();
        ListNode curr = answerList;

        while(l1!=null || l2!=null || carry==1){
            int v1,v2;
            if(l1!=null){
                v1=l1.val;
            }
            else v1=0;
            
            if(l2!=null){
                v2=l2.val;
            }
            else v2=0;

            int total = v1+v2+carry;
            int updateVal;
            if(total>9){
                carry=1;
                updateVal = total%10;
            }
            else {updateVal=total; carry=0;}

            ListNode answer = new ListNode(updateVal);
            if(l1!=null){ l1=l1.next;}
            if(l2!=null){ l2=l2.next;}

            curr.next = answer;
            curr = curr.next;
            
        }
        return answerList.next;
    }
}
