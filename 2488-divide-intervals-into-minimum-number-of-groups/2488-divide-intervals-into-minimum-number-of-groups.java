import java.util.Arrays;

class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        // Separate start and end times into two arrays
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;   // Two pointers for start and end
        int activeGroups = 0;
        int maxGroups = 0;

        // Traverse the start and end times
        while (i < n) {
            if (start[i] <= end[j]) {
                // A new group starts, increment active groups
                activeGroups++;
                i++;
            } else {
                // A group ends, decrement active groups
                activeGroups--;
                j++;
            }

            // Track the maximum number of groups active at once
            maxGroups = Math.max(maxGroups, activeGroups);
        }

        return maxGroups;
    }
}
