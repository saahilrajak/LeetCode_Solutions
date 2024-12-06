class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();

        for (int num : banned) {
            set.add(num);
        }
        
        int count = 0;
        int sum = 0;
        
        for(int num = 1 ; num<=n ; num++){
            if(set.contains(num)){
                continue;
            }
            if(num+sum<=maxSum){
                sum += num;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}