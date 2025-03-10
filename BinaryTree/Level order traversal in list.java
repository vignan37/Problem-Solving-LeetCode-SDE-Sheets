/* 102. Binary Tree Level Order Traversal
Solved
Medium
Topics
Companies
Hint
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if(root == null){
            return finalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //use a queue and while loop
        while(queue.size()!=0){
            // find levelSize and use for loop to pop stuff
            int levelSize = queue.size();
            List<Integer> ls = new ArrayList<>();
            // remove from queue, add childs and update the level list with val
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.remove();
                if(node.left!=null){
                queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                ls.add(node.val);
            }
            finalList.add(ls);
            
        }
        return finalList;
    }
}
