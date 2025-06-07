package June_25_DCC;

import java.util.Stack;

// 06-06-25
public class Using_a_Robot_to_Print_the_Lexicographically_Smallest_String_2434 {
    static class Solution {
        public String robotWithString(String s) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> st = new Stack<>();
            int[] count = new int[26];
            for(int i = 0; i < s.length() ; i+=1) count[s.charAt(i)-'a']++;
            int min = 0;
            for(int i = 0 ; i < s.length();i++){
                int c = s.charAt(i) - 'a';
                count[c]--;
                st.push(c);
                while (min != 25 && count[min] == 0) min++;
                while (!st.isEmpty() && st.peek() <= min) sb.append((char)('a'+st.pop()));
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("bac "+sol.robotWithString("bac"));
        System.out.println("bdda "+sol.robotWithString("bdda"));
    }
}
