import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxStreak = 0;
        
        for (int num : nums) {
            int currentStreak = 0;
            int currentNum = num;
            while (numSet.contains(currentNum)) {
                currentStreak++;
                currentNum *= currentNum;
                if (currentNum > 100000) break;
            }
            if (currentStreak > 1) {
                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }
        return maxStreak >= 2 ? maxStreak : -1;
    }
}

