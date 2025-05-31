package May_25_DCC;

import java.util.*;

public class Largest_color_value_in_a_Directed_graph_1857 {
    static class Solution {
        public int largestPathValue(String colors, int[][] edges) {
            // build the graph
            int n = colors.length();
            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
            int[] indegree = new int[n];
            for(int[] edge : edges){
                graph.get(edge[0]).add(edge[1]);
                indegree[edge[1]]++;
            }


            Queue<Integer> q = new LinkedList<>(); // queue for the dfs
            if(cyclic(n,graph, indegree,q)) return -1; // return -1 if the graph is cyclic

            int[][] dp = new int[n][26];
            for(int[] row: dp) Arrays.fill(row,-1); // dp table initialised with -1

            while(!q.isEmpty()){
                dfs(dp,q.poll(),graph,colors);          // dfs from the node with 0 indegree
            }

            int res = 0;
            for(int[] row : dp){
                res = Math.max(res,Arrays.stream(row).max().getAsInt());   // compute the max value
            }
            return res;
        }

        int[] dfs(int[][] dp, int cur,List<List<Integer>> graph,String color) {
            if(dp[cur][0] != -1) return dp[cur];  // if the current node is already processed return its state

            Arrays.fill(dp[cur],0);     // update the current state is processed at the current stage

            for(int nei: graph.get(cur)){
                int[] newdp = dfs(dp,nei,graph,color);  // get the max_value form next neighbour node
                for(int i = 0;i<26;i++){
                    dp[cur][i] =Math.max(dp[cur][i],newdp[i]);
                }
            }
            dp[cur][color.charAt(cur)-'a']++; // increment the current node color
            return dp[cur];
        }

        private boolean cyclic(int n, List<List<Integer>> graph, int[] indegree,Queue<Integer> q2) {
            Queue<Integer> q = new LinkedList<>();
            for(int i = 0; i < n;i++) if( indegree[i] == 0) {q.offer(i); q2.offer(i);}

            int visited = 0;
            // topological sort with 0 indegree
            while (!q.isEmpty()){
                int cur = q.poll();
                for(int nei : graph.get(cur)) if(--indegree[nei] == 0) q.offer(nei);

                visited++;
            }
            // topological only visit all the node if the graph is acyclic
            return visited != n;
        }
    }
}
