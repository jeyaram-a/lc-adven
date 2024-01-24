// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description
// Pseudo-Palindromic Paths in a Binary Tree

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

    int f(TreeNode root, Set<Integer> set, int c) {
       if(root == null) {
           return 0;
       }
       int val = root.val;
       boolean rem = false;
       if(set.contains(val)) {
           rem = true;
           set.remove(val);
       } else {
           set.add(val);
       }
    
        int ret = 0;
       if(root.left == null && root.right == null) {
           if(c%2 == 0) {
               ret = set.size() == 0 ? 1 : 0;
           } else {
               ret = set.size() == 1 ? 1: 0;
           }
       } else {
           ret = f(root.left, set, c+1) + f(root.right, set, c+1);
       }

       // undo
       if(rem) {
           set.add(val);
       } else {
           set.remove(val);
       }

       return ret;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        return f(root, new HashSet<>(), 1);
    }
}
