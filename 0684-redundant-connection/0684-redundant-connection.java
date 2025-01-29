import java.util.HashMap;
import java.util.Map;
public class Solution {
    static class UnionFind {
        private int[] parent;
        private int[] rank;
        public UnionFind(int size) {
            parent = new int[size + 1];
            rank = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                parent[i] = i;
            }
        }
        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); 
            }
            return parent[node];
        }
        public boolean union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);
            if (root1 == root2) {
                return false; 
            }
            if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int[] redundantEdge = null;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                redundantEdge = edge; 
            }
        }
        return redundantEdge;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {
            {1, 2},
            {1, 3},
            {2, 3}
        };
        int[] result = solution.findRedundantConnection(edges);
        System.out.println("Redundant edge: [" + result[0] + ", " + result[1] + "]");
    }
}