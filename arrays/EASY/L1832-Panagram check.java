class Solution {
    public boolean checkIfPangram(String sentence) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        if(sentence.length() < 26) {
            return false;
        }
        for(int i = 0; i < 26; i++) {
            if(!sentence.contains(String.valueOf(alphabet.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}