import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length); // direct copying
        Arrays.sort(copyArr);
        Map<Integer, Integer> rank = new HashMap<>();
        
        for (int num : copyArr) {
            if (!rank.containsKey(num)) {
                rank.put(num, rank.size() + 1); // Rank starts from 1, hence size + 1
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rank.get(arr[i]);
        }
        //Return the ranked array
        return arr;
    }
}
