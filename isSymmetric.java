/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric(TreeNode root) {
        // Iterative Approach
        if (root == null) {
            return true;
        }

        Stack<TreeNode> s = new Stack<TreeNode>();

        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null || root.right == null) {
            return false;
        }

        s.push(root.left);
        s.push(root.right);

        while (!s.isEmpty()) {
            TreeNode right = s.pop();
            TreeNode left = s.pop();

            if (right.val != left.val) {
                return false;
            }

            if (left.right != null && right.left == null) {
                return false;
            } else if (left.right == null && right.left != null) {
                return false;
            } else if (left.right != null && right.left != null) {
                s.push(left.right);
                s.push(right.left);
            }

            if (left.left != null && right.right == null) {
                return false;
            } else if (left.left == null && right.right != null) {
                return false;
            } else if (left.left != null && right.right != null) {
                s.push(left.left);
                s.push(right.right);
            }
        }

        return true;
    }
}

/*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Recursive Approach
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else if (node1.val != node2.val) {
            return false;
        }

        return helper(node1.right, node2.left) && helper(node1.left, node2.right);
    }
}
*/
