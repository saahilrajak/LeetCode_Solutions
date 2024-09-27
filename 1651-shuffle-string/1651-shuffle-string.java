class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        int j = 0;
        for(int i=0;i<indices.length;i++){
            arr[indices[i]] = s.charAt(j);
            j++;
        }
        return new String(arr);
    }
}