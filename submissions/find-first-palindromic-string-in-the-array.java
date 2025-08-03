class Solution {
    public String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(isPalindrome(words[i])){
                return words[i];
            }
        }
        return "";
    }
    
    boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}