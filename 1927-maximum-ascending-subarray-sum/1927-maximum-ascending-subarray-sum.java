class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int maxSum = 0; // declarring maxSum as 0;
        int sum = nums[0]; // storing the value of nums present at i position in sum;
        // running the loop from i to length of the nums
        for(int i=1; i<n; i++){
          if(nums[i] > nums[i-1]){                  
            sum += nums[i];
          }
          else{
            maxSum = Math.max(maxSum, sum);
            sum = nums[i]; // updating the sum whenver the i is in decrasing point ex: 10,20,30,5,70,80
            // after the condition i is updated to 5;
          }
        }
        return Math.max(maxSum, sum);
    }
}

