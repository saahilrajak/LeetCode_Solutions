
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        List<int[]> events = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            events.add(new int[]{times[i][0], 1, i});
            events.add(new int[]{times[i][1], 0, i});
        }

        Collections.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        int[] friendToChair = new int[n];

        for (int[] event : events) {
            int time = event[0];
            int type = event[1];
            int friend = event[2];

            if (type == 1) {
                int chair = availableChairs.poll();
                friendToChair[friend] = chair;
                
                if (friend == targetFriend) {
                    return chair;
                }
            } else {
                availableChairs.add(friendToChair[friend]);
            }
        }

        return -1;
    }
}
