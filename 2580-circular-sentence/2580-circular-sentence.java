class Solution {
    public boolean isCircularSentence(String sentence) {

        //Tc: O(n)
        //Sc: O(1)
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i) == ' ' && sentence.charAt(i-1) != sentence.charAt(i+1)){
                return false;
            }
        }
        return sentence.charAt(0) == sentence.charAt(sentence.length()-1);
    }
}