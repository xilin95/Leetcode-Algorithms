/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /**
  * Definition for a binary tree node.
  * public class TreeNode {
  *     int val;
  *     TreeNode left;
  *     TreeNode right;
  *     TreeNode(int x) { val = x; }
  * }
  */
 class Solution {
     public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList<Integer>();
         Stack<TreeNode> visiting = new Stack<TreeNode>();
         if (root != null) {
             visiting.push(root);
         }

         while (!visiting.isEmpty()) {
             TreeNode curr = visiting.pop();

             result.add(curr.val);
             if (curr.right != null) {
                 visiting.push(curr.right);
             }

             if (curr.left != null) {
                 visiting.push(curr.left);
             }


         }

         return result;

     }
 }
