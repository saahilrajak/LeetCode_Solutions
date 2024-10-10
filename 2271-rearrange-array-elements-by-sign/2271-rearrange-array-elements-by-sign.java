class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] posArray = new int[nums.length];
        int[] negArray = new int[nums.length];
        int posIndex = 0;
        int negIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                posArray[posIndex] = nums[i];
                posIndex++;
            } else {
                negArray[negIndex] = nums[i];
                negIndex++;
            }
        }

        int[] result1 = new int[posIndex];
        int[] result2 = new int[negIndex];

        System.arraycopy(posArray, 0, result1, 0, posIndex);
        System.arraycopy(negArray, 0, result2, 0, negIndex);

        int[] finalResult = new int[nums.length];
        int index = 0;

        for (int i = 0; i < result1.length && i < result2.length; i++) {
            finalResult[index++] = result1[i];
            finalResult[index++] = result2[i];
        }

        return finalResult;
    }
}
