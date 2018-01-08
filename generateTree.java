/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return generateList(1, n);
    }

    private List<TreeNode> generateList(int start, int end) {
        List<TreeNode> l = new ArrayList<TreeNode>();

        if (start > end) {
            l.add(null);
            return l;
        } else {
            for (int i = start; i <= end; i++) {
                // generate lists of left BSTs and right BSTs for all potential roots
                List<TreeNode> leftBST = generateList(start, i - 1);
                List<TreeNode> rightBST = generateList(i + 1, end);
                // Creates many different combinations
                for (TreeNode leftNode: leftBST) {
                    for (TreeNode rightNode: rightBST) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        l.add(root);
                    }
                }
            }

        }
        return l;
    }
}
