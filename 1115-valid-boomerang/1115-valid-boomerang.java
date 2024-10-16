class Solution {
    public boolean isBoomerang(int[][] points) {
        int dx1 = points[1][0]-  points[0][0];
        int dx2 = points[2][0] - points[1][0];
        int dy1 = points[1][1] - points[0][1];
        int dy2 = points[2][1] - points[1][1];

        return (dx1*dy2 != dx2*dy1);
    }
}