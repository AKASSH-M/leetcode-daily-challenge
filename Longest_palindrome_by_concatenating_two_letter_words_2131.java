import java.util.HashMap;
import java.util.Map;

public class Longest_palindrome_by_concatenating_two_letter_words_2131 {
    static class Solution {
        public int longestPalindrome(String[] words) {
            Map<String,Integer> map = new HashMap<>();
            for(String w : words) map.put(w, map.getOrDefault(w,0)+1);
            int res = 0;
            boolean odd = false;
            for(String key : map.keySet()){
                if(key.charAt(0) == key.charAt(1)){
                    int count = map.get(key);
                    map.put(key,0);
                    odd |= (count&1) == 1;
                    count /=2;
                    res += count*4;
                }
                else{
                    String rev = ""+key.charAt(1) + key.charAt(0);
                    int c = map.get(key) , rc = map.getOrDefault(rev,0);
                    map.put(key,0); if(rc != 0) map.put(rev,0);
                    int count = Math.min(c,rc);
                    res += count * 4;
                }

            }
            return res + (odd ? 2 :0);
        }
    }
}
