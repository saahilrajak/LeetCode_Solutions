import java.util.PriorityQueue;
import java.util.Collections;
import java.lang.Math;

class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;

        // Initialize a max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements of the array to the heap
        for (int num : nums) {
            pq.offer(num);
        }
        // Process the top k elements
        while (k-- > 0) {
            // Get the maximum element from the heap
            int maxEl = pq.poll(); // This removes the element

            // Add it to the score
            score += maxEl;

            // Compute the ceiling of maxEl / 3.0
            int newEl = (int) Math.ceil(maxEl / 3.0);

            // Insert the updated element back into the heap
            pq.offer(newEl);
        }

        return score;
    }
}
