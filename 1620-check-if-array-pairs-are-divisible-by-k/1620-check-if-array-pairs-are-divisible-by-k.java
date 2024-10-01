import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> remainderFrequency = new HashMap<>();

        for (int val : arr) {
            int rem = ((val % k) + k) % k;  // Handle negative remainders
            int oldFrequency = remainderFrequency.getOrDefault(rem, 0);
            remainderFrequency.put(rem, oldFrequency + 1);
        }
        
        for (int val : arr) {
            int rem = ((val % k) + k) % k;

            if (rem == 0) { //If the remainder is 0, its frequency should be even
                int frequency = remainderFrequency.get(rem);
                if (frequency % 2 != 0) {
                    return false;
                }
            } 
            else if (2 * rem == k) {//the frequency of that remainder should be even
                int frequency = remainderFrequency.get(rem);
                if (frequency % 2 != 0) {
                    return false;
                }
            }
            else { //the frequency of rem and k - rem should match
                int frequency = remainderFrequency.get(rem);
                int otherFrequency = remainderFrequency.getOrDefault(k - rem, 0);
                if (frequency != otherFrequency) {
                    return false;
                }
            }
        }
        return true;
    }
}
