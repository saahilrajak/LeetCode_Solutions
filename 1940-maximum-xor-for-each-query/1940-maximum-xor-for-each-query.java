class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        Vector<Integer> n = new Vector<>(result(n));
        int XOR = 0;
        for(int i = 0;i <n ;i++){
            XOR ^= nums[i];
        }
        int mask = ((1<< maximumBit) -1);
        for(int i = 0; i<n ;i++){
            int k = XOR ^ mask;
            result[i] = k;
            XOR = (XOR ^ nums[n-1-i]);
        }
        return result;
    }
}