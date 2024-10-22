import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        // Max-heap (using reverse order)
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0;
            // Sum all node values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                sum += curr.val;

                // Add children to the queue for the next level
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            pq.add(sum);
        }
        if (pq.size() < k) {
            return -1;
        }
        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }
        return pq.peek();
    }
}
