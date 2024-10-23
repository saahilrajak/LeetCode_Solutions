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
import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // Checking if the current node's children are x and y
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || 
                        (node.left.val == y && node.right.val == x)) {
                        return false; // x and y are siblings, not cousins
                    }
                }
                // Check for x and y at the current level
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) foundX = true;
                    if (node.left.val == y) foundY = true;
                }
                
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) foundX = true;
                    if (node.right.val == y) foundY = true;
                }
            }
            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }
        return false;
    }
}
