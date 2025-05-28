import java.util.*;
// brute force / optimal solution will be updated
public class Maximize_the_Number_of_Target_Nodes_After_Connection_Trees_I {
    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
            int n = edges1.length + 1;
            int m = edges2.length + 1;
            List<List<Integer>> tree1 = new ArrayList<>();
            List<List<Integer>> tree2 = new ArrayList<>();

            for(int i = 0; i < n ; i++) tree1.add(new ArrayList<>());
            for(int i = 0; i < m ; i++) tree2.add(new ArrayList<>());

            for(int[] edge : edges1){
                tree1.get(edge[0]).add(edge[1]);
                tree1.get(edge[1]).add(edge[0]);
            }
            for(int[] edge : edges2){
                tree2.get(edge[0]).add(edge[1]);
                tree2.get(edge[1]).add(edge[0]);
            }
            int[] tree1_k = get_target(n,tree1,k);
            int max = Arrays.stream(get_target(m,tree2,k)).max().getAsInt() - 1;

            for(int i = 0; i < n ; i++) tree1_k[i] += max;

            return tree1_k;
        }

        private int[] get_target(int n, List<List<Integer>> tree1,int k) {
            int[] res = new int[n];
            for(int i = 0 ; i < n;i++) res[i] = bfs_length(tree1,i,k,n);
            return res;
        }

        private int bfs_length(List<List<Integer>> tree, int cur, int k,int n) {
            int nodes = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(cur);
            int level = 0;
            boolean[] visited = new boolean[n];
            visited[cur] = true;
            while (!q.isEmpty() && level++<=k){
                int size = q.size();
                while (size-->0){
                    cur = q.poll();
                    nodes++;
                    for(int nei : tree.get(cur)) if(!visited[nei]) {
                        visited[nei] = true;
                        q.offer(nei);
                    }
                }
            }
            return nodes;
        }
    }
}
