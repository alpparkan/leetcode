import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (dfs(adj, visited, 0)) {
                count++;
            }
        }
        return count;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, int node) {
        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        for (Integer nei : adj.get(node)) {
            if (!visited.contains(nei) && !dfs(adj, visited, nei)) {
                return false;
            }
        }
        return true;
    }
}
