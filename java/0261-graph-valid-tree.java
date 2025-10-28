import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean res = dfs(adj, visited, 0, -1);
        return res && visited.size() == n;
    }

    boolean dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, int node, int parent) {
        if (visited.contains(node)) {
            return false;
        }
        
        visited.add(node);
        for (Integer a : adj.get(node)) {
            if (a != parent && !dfs(adj, visited, a, node)) {
                return false;
            }
        }
        return true;
    }
}
