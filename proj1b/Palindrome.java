public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dc = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++){
            dc.addLast(word.charAt(i));
        };
        return dc;
    }

    public boolean isPalindrome(String word){
        Deque<Character> res = wordToDeque(word);
        return isPalindromeHelper(res);
    }    

   
    private boolean isPalindromeHelper(Deque<Character> cd) {
        if(cd.size()== 0 || cd.size() == 1){
            return true;
        }
        char a = cd.removeFirst();
        char b = cd.removeLast();
        if(a == b){
            return isPalindromeHelper(cd);
        }else{
            return false;
        }
    }

     public boolean isPalindrome(String word, CharacterComparator cc){

        Deque<Character> res = wordToDeque(word);
        return isPalindromeHelperover(res, cc);
        
    }

    private boolean isPalindromeHelperover(Deque<Character> cd, CharacterComparator cc) {
        if(cd.size()== 0 || cd.size() == 1){
            return true;
        }
        char a = cd.removeFirst();
        char b = cd.removeLast();
        if(cc.equalChars(a, b)){
            return isPalindromeHelperover(cd, cc);
        }else{
            return false;
        }
    }
    
  


}
