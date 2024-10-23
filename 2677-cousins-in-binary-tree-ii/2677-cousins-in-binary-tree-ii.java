import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelSum = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            levelSum.add(sum);
        }
        
        root.val = 0;
        int levelIdx = 1;
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int sibSum = 0;
                if (node.left != null) sibSum += node.left.val;
                if (node.right != null) sibSum += node.right.val;
                
                if (node.left != null) {
                    node.left.val = levelSum.get(levelIdx) - sibSum;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = levelSum.get(levelIdx) - sibSum;
                    queue.add(node.right);
                }
            }
            levelIdx++;
        }
        return root;
    }
}
