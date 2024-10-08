class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDuplicates = 0;
        int length = arr.length - 1;

        for (int i = 0; i <= length - possibleDuplicates; i++) {
            if (arr[i] == 0) {
                if (i == length - possibleDuplicates) {
                    arr[length] = 0;
                    length -= 1;
                    break;
                }
                possibleDuplicates++;
            }
        }

        for (int i = length - possibleDuplicates; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDuplicates] = 0;
                possibleDuplicates--;
                arr[i + possibleDuplicates] = 0;
            } else {
                arr[i + possibleDuplicates] = arr[i];
            }
        }
    }
}
