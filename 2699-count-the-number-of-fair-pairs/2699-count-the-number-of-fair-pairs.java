class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLess(nums,upper)-countLess(nums,lower-1);
    }
    //creater a helper method and it is only accesible to the solution class
    private long countLess(int[] nums, int sum){
        long result = 0;
        int j = nums.length-1;
        for(int i = 0; i<j ;i++){
            while(i<j && nums[i]+nums[j]>sum){
                --j;
            }
            result = result + (j-i);
        }
        return result;
    }
}
