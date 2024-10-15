class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minSpeed = 1;
        int maxSpeed = Integer.MAX_VALUE;
        
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            if (canEatAll(piles, h, mid)) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }
    private boolean canEatAll(int[] piles, int h, int k) {
        int hoursSpent = 0;
        for (int pile : piles) {
            hoursSpent += (pile + k - 1) / k;
        }
        return hoursSpent <= h;
    }
}
