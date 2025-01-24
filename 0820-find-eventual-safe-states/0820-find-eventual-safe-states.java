//Time complexity: O(V+E)
//Space Complexity: O(V+E)

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        
        // Build adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
            for (int v : graph[i]) {
                adj.get(i).add(v);
            }
        }

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        boolean[] isSafe = new boolean[V];

        // Check for cycles and mark safe nodes
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycleDFS(adj, i, visited, inRecursion, isSafe);
            }
        }

        // Collect all safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isSafe[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean isCycleDFS(List<List<Integer>> adj, int u, boolean[] visited, boolean[] inRecursion, boolean[] isSafe) {
        visited[u] = true;
        inRecursion[u] = true;

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (isCycleDFS(adj, v, visited, inRecursion, isSafe)) {
                    return true; // Cycle detected
                }
            } else if (inRecursion[v]) {
                return true; // Cycle detected
            }
        }

        inRecursion[u] = false; // Backtrack
        isSafe[u] = true; // Mark node as safe
        return false; // No cycle detected
    }
}