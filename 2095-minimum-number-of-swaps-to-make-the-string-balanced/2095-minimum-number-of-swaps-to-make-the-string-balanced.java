class Solution {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int imbalance = 0;
        int maxImbalance = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                imbalance++;
            } else if (chars[i] == ']') {
                imbalance--;
            }
            maxImbalance = Math.min(maxImbalance, imbalance);
        }
        return (-maxImbalance + 1) / 2;
    }
}
