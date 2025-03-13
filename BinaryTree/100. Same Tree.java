/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //basecase check if both are null
        if(p == null && q ==null){return true;}
        // if one of them is null then its not same
        if(p==null && q!=null || p!=null && q==null){return false;}
        // if both are there, then check the value in it, if not same then no.
        if(p.val != q.val){
            return false;
        }
        // use recursion if both values are same.
        boolean isSameTreeLeft = isSameTree(p.left,q.left);
        boolean isSameTreeRight = isSameTree(p.right,q.right);
        if(isSameTreeLeft && isSameTreeRight){ return true;}
        else{return false;}
    }
}

/*
100. Same Tree
Solved
Easy
Topics
Companies
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false
*/
