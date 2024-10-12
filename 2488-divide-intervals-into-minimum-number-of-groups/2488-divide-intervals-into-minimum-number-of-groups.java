import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        
        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1] + 1;
            treeMap.put(startTime, treeMap.getOrDefault(startTime, 0) + 1);
            treeMap.put(endTime, treeMap.getOrDefault(endTime, 0) - 1);
        }

        int currentCount = 0;
        int maxCount = 0;

        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            currentCount += entry.getValue();
            maxCount = Math.max(currentCount, maxCount);
        }

        return maxCount;
    }
}
