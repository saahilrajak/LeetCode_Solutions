public class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;

        for (int i = 0; i < m; i++) {
            int fallPosition = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][fallPosition] = '#';
                    fallPosition--;
                } else if (box[i][j] == '*') {
                    fallPosition = j - 1;
                }
            }
        }

        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }
}
