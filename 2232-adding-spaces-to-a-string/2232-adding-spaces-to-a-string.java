class Solution {
    public String addSpaces(String s, int[] spaces) {
         StringBuilder sb = new StringBuilder(s);
         int spaceCount = 0;
         for(int i=0;i<spaces.length;i++){
            sb.insert(spaces[i] + spaceCount, " ");
            spaceCount++;
         }
         return sb.toString();
    }
}