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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorderHelper(root,result);
        return result;
    }

    public void preorderHelper(TreeNode root, List<Integer> result){
        if(root==null) return;

        result.add(root.val);
        preorderHelper(root.left, result);
        preorderHelper(root.right, result);
        return;
    }
}

//Iterative preorder traversal o(n) space complexity
/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root ==null) return list ;

        Stack<TreeNode> s = new Stack<TreeNode>();
        
        s.push(root);
        while(s.isEmpty()==false){
               TreeNode curr = s.pop();   
                
                list.add(curr.val);    
                if(curr.right!=null) s.push(curr.right);
            if(curr.left!=null) s.push(curr.left); 
    }
     return list;
    }
}
*/

// Iterative preorder traversal of space complexity o(h)

/*
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root ==null) return list ;
        Stack<TreeNode> s = new Stack<TreeNode>();
         
        TreeNode curr = root;
        while(s.isEmpty()==false || curr!=null){
            while(curr!=null){

                list.add(curr.val);
                
                if(curr.right!=null){
                    s.push(curr.right);
                    }
                curr = curr.left; 
                }
            
            if(s.isEmpty()==false){curr = s.pop();}
            }
            return list;
            }
            }
            */
