package June_25_DCC;

import java.util.Arrays;

// 05-06-25
public class Lexicographically_smallest_Equivalent_String_1061 {
    static class Solution {
        public String smallestEquivalentString(String s1, String s2, String baseStr) {
            int parent[] = new int[26];
            for(int i = 0 ; i < 26 ; i++) parent[i] = i;
            for(int i = 0; i < s1.length() ; i++){
                union(parent,s1.charAt(i)-'a',s2.charAt(i)-'a');
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < baseStr.length() ; i++){
                sb.append((char)('a'+parent(parent,baseStr.charAt(i)-'a')));
            }
            return sb.toString();
        }
        private int parent(int[] parent , int n){
            while (parent[n] != n){
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }
        private void union(int[] parent , int u , int v){
            int p1 = parent(parent,u), p2 = parent(parent,v);
            if(p1 != p2) parent[Math.max(p1,p2)] = Math.min(p1,p2);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestEquivalentString("leetcode","programs","sourcecode"));
    }
}
