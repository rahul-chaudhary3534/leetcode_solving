import java.util.*;

class Solution {

    public int countCompleteComponents(int n, int[][] edges) {

        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Step 2: Find every connected component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // info[0] = number of nodes
                // info[1] = sum of degrees
                int[] info = new int[2];

                dfs(i, adj, visited, info);

                int nodes = info[0];
                int degreeSum = info[1];

                // For a complete component:
                // degreeSum = nodes * (nodes - 1)
                if (degreeSum == nodes * (nodes - 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int node,
                     List<List<Integer>> adj,
                     boolean[] visited,
                     int[] info) {

        visited[node] = true;

        // Count current node
        info[0]++;

        // Add degree of current node
        info[1] += adj.get(node).size();

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, info);
            }
        }
    }
}