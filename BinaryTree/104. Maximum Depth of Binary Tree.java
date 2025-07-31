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

//using recursion
// find the left depth and right depth and return 1 + max of them, recurrsion will handle the rest
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        if(root.left ==null && root.right == null){ return 1 ;}
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// Using level order traversal
// find the number of levels its the max depth.
public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int totalLevels =0;
        while(!q.isEmpty()){
            totalLevels++;
            int levelSize = q.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.remove();
                if(node.left!=null){q.add(node.left);}
                if(node.right!=null){q.add(node.right);}
            }
        }
        return totalLevels;
    }

/*

104. Maximum Depth of Binary Tree
Solved
Easy
Topics
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100*/
