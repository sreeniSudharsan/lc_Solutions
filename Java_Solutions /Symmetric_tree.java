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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode leftNode, TreeNode rightNode){
        if(leftNode==null && rightNode==null)
            return true;
        if(leftNode!=null && rightNode!=null && leftNode.val==rightNode.val)
            return (isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left));
        return false;
    }
}
