package May_25_DCC;

import java.util.*;

public class Maximize_the_Numbers_of_target_Nodes_After_connection_tree_II_3373 {
    static class Solution {
        public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
            int n = edges1.length + 1 , m = edges2.length + 1;
            List<List<Integer>> tree1 = build_tree(n,edges1);
            List<List<Integer>> tree2 = build_tree(m,edges2);
            System.out.println("tree built");

            int[] res = bfs(tree1,true,n);
            int max = bfs(tree2,false,m)[0];

            for(int i = 0 ; i < n ; i++){
                res[i] += max;
            }

            return res;
        }

        private int[] bfs(List<List<Integer>> tree, boolean even, int n) {
            int[] res = even ? new int[n] : null;
            int even_nodes = 0 , odd_nodes = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);
            int[] state = new int[n];
            Arrays.fill(state,-1);
            state[0] = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                even_nodes += even ? size : 0;
                odd_nodes += !even ? size : 0;
                while (size-->0){
                    for(int nei : tree.get(queue.poll()))if(state[nei] == -1)
                    { queue.add(nei); state[nei] = even? 1 : 0;}
                }
                even = !even;
            }
            if(res == null) return new int[]{Math.max(odd_nodes,even_nodes)};
            for(int i = 0 ; i < n ; i++) res[i] = state[i] == 0 ? even_nodes : odd_nodes;
            return res;
        }

        private List<List<Integer>> build_tree(int n, int[][] edges) {
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0;i < n ; i++) {
                tree.add(new ArrayList<>());
            }
            for (int[] edge : edges){ tree.get(edge[1]).add(edge[0]); tree.get(edge[0]).add(edge[1]); }
            return tree;
        }
    }
}
