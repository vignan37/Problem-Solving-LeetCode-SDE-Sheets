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
// Balanced tree is height difference is not more than one
class Solution {
    public boolean isBalanced(TreeNode root) {
        // Base case: An empty tree is balanced
        if(root == null) { 
            return true;
        }

        // Check if the difference in heights of left and right subtrees is greater than 1
        if(Math.abs(heightOfBST(root.left) - heightOfBST(root.right)) > 1) {
            return false;
        }

        // Recursively check if left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int heightOfBST(TreeNode root) {
        // Base case: Height of a null node is zero
        if(root == null) {
            return 0;
        }
        // Leaf node has height 1
        if(root.left == null && root.right == null) {
            return 1;
        }
        // Calculate height recursively by taking max of left and right subtree heights
        return 1 + Math.max(heightOfBST(root.left), heightOfBST(root.right));
    }
}


/*
110. Balanced Binary Tree
Solved
Easy
Topics
Companies
Given a binary tree, determine if it is height-balanced.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:


Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
*/
