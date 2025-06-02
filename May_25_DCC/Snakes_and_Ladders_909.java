package May_25_DCC;

import java.util.LinkedList;
import java.util.Queue;

public class Snakes_and_Ladders_909 {
    static class Solution {
        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(1);
            boolean[] visited = new boolean[n*n];
            visited[0] = true;
            int res = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size-->0){
                    int cur = queue.poll();
                    if (cur == n * n) return res;
                    for(int i = 1; i < 7 && i + cur <= n * n ;i++){
                        int[] next = pos(i+cur,n);
                        int nei = board[next[0]][next[1]] != -1 ? board[next[0]][next[1]] : cur + i;
                        if(!visited[nei -1]){
                            visited[nei - 1] = true;
                            queue.offer(nei);
                        }
                    }
                }
                res++;
            }
            return -1;
        }
        private int[] pos(int pos,int n) {
            int x = n - 1 - (pos - 1) / n;
            boolean str = (n - 1 - x) % 2 == 0;
            int y = str ? (pos - 1) % n : n - 1 - ((pos - 1) % n);
            return new int[]{x, y};
        }
    }
}
