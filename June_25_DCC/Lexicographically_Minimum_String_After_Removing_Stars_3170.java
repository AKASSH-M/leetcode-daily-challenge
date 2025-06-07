package June_25_DCC;

import java.util.PriorityQueue;
import java.util.Stack;

// 07-06-25
public class Lexicographically_Minimum_String_After_Removing_Stars_3170 {
    static class Solution {
        public String clearStars(String s) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b));
            Stack<Integer>[] st = new Stack[26];
            int n = s.length();
            boolean[] chars = new boolean[n];
            boolean[] nums = new boolean[26];
            for(int i = 0; i < n;i++){
                if(s.charAt(i)=='*'){
                    while (!pq.isEmpty() && (st[pq.peek()] == null || st[pq.peek()].isEmpty())) nums[pq.poll()] = false;
                    int idx = st[pq.peek()].pop();
                    chars[idx] = chars[i] = true;
                }
                else{
                    int idx = s.charAt(i)-'a';
                    if(st[idx] == null) st[idx] = new Stack<>();
                    st[idx].push(i);
                    if(!nums[idx]){
                        pq.offer(idx); nums[idx] = true;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i= 0 ; i < n ; i++) if(!chars[i]) sb.append(s.charAt(i));
            return sb.toString();
        }
    }
}
