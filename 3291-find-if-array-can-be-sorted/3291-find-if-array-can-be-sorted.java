class Solution {
    public boolean canSortArray(int[] nums) {
        int countSetBits = Integer.bitCount(nums[0]);
        int prevSegmentMax = -1;
        int currSegmentMax = nums[0];
        int currSegmentMin = nums[0];
        for(int i=1; i<nums.length; i++){
            if(Integer.bitCount(nums[i]) != countSetBits){
                countSetBits = Integer.bitCount(nums[i]);
                prevSegmentMax = Math.max(prevSegmentMax, currSegmentMax);
                currSegmentMax = nums[i];
                currSegmentMin = nums[i];
            }
            else{
                currSegmentMax = Math.max(currSegmentMax, nums[i]);
                currSegmentMin = Math.min(currSegmentMin, nums[i]);

            }
            if(prevSegmentMax >= currSegmentMin){
                return false;
            }
        }
        return true;
    }
}