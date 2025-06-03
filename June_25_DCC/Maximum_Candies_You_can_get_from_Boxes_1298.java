package June_25_DCC;

import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Candies_You_can_get_from_Boxes_1298 {
    static class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
            int n = status.length;
            boolean[] open = new boolean[n];
            boolean[] visited = new boolean[n];
            boolean[] inhand = new boolean[n];

            for(int box : initialBoxes) inhand[box] = true;
            for(int i = 0; i< n ; i++){
                open[i] = status[i] == 1;
            }
            int res = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ;i < n;i++)
                if(open[i] && inhand[i]){
                    visited[i] = true;
                    queue.offer(i);
                }

            while (!queue.isEmpty()){
                int box = queue.poll();
                res += candies[box];
                for(int nbox : containedBoxes[box]){
                    inhand[nbox] = true;
                    if(inhand[nbox] && !visited[nbox]){
                        visited[nbox] = true;
                        queue.offer(nbox);
                    }
                }
                for(int nbox : keys[box]){
                    open[nbox] = true;
                    if(inhand[nbox] && !visited[nbox]){
                        visited[nbox] = true;
                        queue.offer(nbox);
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxCandies(new int[]{1,0,1,0},new int[]{7,5,4,100},new int[][]{{},{},{1},{}},new int[][]{{1,2},{3},{},{}},new int[]{0}));
    }
}
