package May_25_DCC;

import java.util.Arrays;

public class Find_Closest_Node_Given_Two_Nodes_2359 {
    static class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            int n = edges.length;
            int[] dist1 = new int[n];
            int[] dist2 = new int[n];

            Arrays.fill(dist1,Integer.MAX_VALUE);
            Arrays.fill(dist2,Integer.MAX_VALUE);

            dfs(edges,node1,dist1,0);
            dfs(edges,node2,dist2,0);

            int res = -1 ,  d = Integer.MAX_VALUE;
            for(int i = 0 ;i < n;i++)
                if(d> Math.max(dist1[i],dist2[i])){
                    d = Math.max(dist1[i],dist2[i]);
                    res = i;
                }
            return res;
        }

        private void dfs(int[] edges, int node, int[] dist,int d) {
            if(node == -1 || dist[node] < d) return;
            dist[node] = d;
            dfs(edges,edges[node],dist,d+1);
        }
    }
}
