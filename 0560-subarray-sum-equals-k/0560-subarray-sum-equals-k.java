class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0;i<n; i++){
          int sum = 0;
          for(int j=i;j<n;j++){
            sum += nums[j]; // sum of( i-j-1)+arr[j];
            // Increase the count if sum == k
            if(sum == k){
              count++;
            }
          }
        }
      return count;
    }
}