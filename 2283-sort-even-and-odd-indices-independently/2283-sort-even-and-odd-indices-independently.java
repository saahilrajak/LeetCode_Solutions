class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int N = nums.length;
        int[] oddArr = new int[N / 2 ];
        int[] evenArr = new int[(N + 1) / 2];
        int j = 0;
        int k = 0;

        for (int i=0; i<N; i++)
        {
            if (i % 2 == 0)
            {
                evenArr[j++] = nums[i];
            }
            else
            {
                oddArr[k++] = nums[i];
            }
        }

        Arrays.sort(evenArr);
        Arrays.sort(oddArr);

        int m = 0;
        int n = oddArr.length - 1;
        for (int i=0; i<nums.length; i++) 
        {
            if (i % 2 == 0) 
            {
                nums[i] = evenArr[m++];
            } else 
            {
                nums[i] = oddArr[n--];
            }
        }
        return nums;
    }
}