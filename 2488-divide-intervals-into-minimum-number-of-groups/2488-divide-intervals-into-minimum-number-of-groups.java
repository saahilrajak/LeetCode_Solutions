import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minGroups(int[][] intervals) {
        // List to store all the events
        List<int[]> events = new ArrayList<>();

        // For each interval, we store two events: start (+1) and end (-1)
        for (int[] interval : intervals) {
            events.add(new int[] {interval[0], 1});  // +1 for the start of an interval
            events.add(new int[] {interval[1] + 1, -1}); // -1 for the end of an interval
        }

        // Sort events: first by time, if equal then by type (-1 before +1 to handle end before start)
        Collections.sort(events, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1]; // prioritize -1 over +1 if times are equal
            return a[0] - b[0];
        });

        int maxCount = 0;
        int currentCount = 0;

        // Sweep through the sorted events
        for (int[] event : events) {
            currentCount += event[1];  // Add 1 for start, subtract 1 for end
            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
