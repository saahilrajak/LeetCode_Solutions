class Solution {
    public int singleNonDuplicate(int[] nums) {
        int number = nums.length;
        if(number == 1) return nums[0]; // edge cases
        if(nums[0] != nums[1]) return nums[0]; //edge case if the element is on first index
        if(nums[number-1] != nums[number-2]) return nums[number-1];// edge case if the element is on last index
        int low = 1;
        int high = number-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            // Elimination condition for left half 
            if(mid%2 == 1 && nums[mid-1] == nums[mid] || mid%2 == 0 && nums[mid+1] == nums[mid]){
                low = mid+1;
            }
            else{ // Elimation condition for right half
                high = mid-1;
            }
        }
        return -1; //in case all the above condition doesn't get executed this edge case will going to be executed
    }
}