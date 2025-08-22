
    
    /*
    If we can reverse the second half of linked list, we can compare each value from left and right.
    To do that, we will take 3 steps.
        Find middle of the linked list
        Reverse the second half of the list
        Compare nodes one by one
    */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
    
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
    
            ListNode prev = null;
            while (slow != null) {
                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }
    
            ListNode first = head;
            ListNode second = prev;
    
            while (second != null) {
                if (first.val != second.val) {
                    return false;
                }
                first = first.next;
                second = second.next;
            }
    
            return true; 
        }
    }
    
    // Using stack approach
    /*
    class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> s = new Stack<>();
            ListNode p = head;
            while(p!=null){
                s.push(p);
                p = p.next;
            }
            while(!s.isEmpty()){
                if(s.pop().val!=head.val){
                    return false;
                }
                head= head.next;
            }
            return true;
        }
    }
    */
    
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
    ```
    

/*

- Q
    
    # [**234. Palindrome Linked List**](https://leetcode.com/problems/palindrome-linked-list/)
    
    Given the `head` of a singly linked list, return `true` *if it is a palindrome or* `false` *otherwise*.
    
    **Example 1:**
    
    ![](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg)
    
    ```
    Input: head = [1,2,2,1]
    Output: true
    
    ```
    
    **Example 2:**
    
    ![](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg)
    
    ```
    Input: head = [1,2]
    Output: false
    
    ```
    
    **Constraints:**
    
    - The number of nodes in the list is in the range `[1, 105]`.
    - `0 <= Node.val <= 9`
    
    **Follow up:**
    
    Could you do it in
    
    ```
    O(n)
    ```
    
    time and
    
    ```
    O(1)
    ```
    
    space?
    

*/