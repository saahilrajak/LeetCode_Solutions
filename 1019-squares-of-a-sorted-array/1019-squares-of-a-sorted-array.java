class Solution {
    public int[] sortedSquares(int[] nums) {
       int[] result = new int[nums.length];

       for(int i=0;i<nums.length;i++){
        nums[i] = nums[i]*nums[i];
       }

       int h = 0;
       int t = nums.length-1;

       for(int pos = nums.length-1;pos>=0;pos--){
        if(nums[h]>nums[t]){
            result[pos] = nums[h];
            h++;
        }
        else{
            result[pos] = nums[t];
            t--;
        }
       }
       return result;
    }
}