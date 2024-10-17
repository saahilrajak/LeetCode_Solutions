class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] lastOcc = new int[10]; // storing last occurence of each digit
        for (int i = 0; i < digits.length; i++) {
            lastOcc[digits[i] - '0'] = i;
        }

        for(int i = 0 ; i<digits.length ; i++){ // loo out for the first place where a larger digit can be swapped
            for (int d = 9; d > digits[i] - '0'; d--) { //checking if we can find a larger digit, sin decreasing order of 9-current digit
                if (lastOcc[d] > i) {
                    char temp = digits[i];
                    digits[i] = digits[lastOcc[d]];
                    digits[lastOcc[d]] = temp;
                    return Integer.parseInt(new String(digits));
            }
        }
    }
    return num;
  }
}