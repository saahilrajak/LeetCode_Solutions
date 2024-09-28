import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> evenIndices = new ArrayList<>();
        ArrayList<Integer> oddIndices = new ArrayList<>();
        // Separate even and odd indexed elements
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                evenIndices.add(nums[i]);
            } else {
                oddIndices.add(nums[i]);
            }
        }
        // Sort even indices in ascending order
        Collections.sort(evenIndices);
        // Sort odd indices in descending order
        Collections.sort(oddIndices, Collections.reverseOrder());
        // Place sorted elements back into original array
        int evenIndex = 0, oddIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = evenIndices.get(evenIndex++);
            } else {
                nums[i] = oddIndices.get(oddIndex++);
            }
        }
        
        return nums;
    }
}