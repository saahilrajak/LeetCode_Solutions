class Solution {
    public int minAddToMakeValid(String s) {
        int leftUnmatched = 0;
        int rightUnmatched = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftUnmatched++;
            } else if (ch == ')') {
                if (leftUnmatched > 0) {
                    leftUnmatched--;
                } else {
                    rightUnmatched++;
                }
            }
        }

        return leftUnmatched + rightUnmatched;
    }
}
