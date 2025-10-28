// Definition for a Node.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
    // BFS
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        visited.put(node, new Node(node.val));

        while(!q.isEmpty()) {
            Node n = q.poll();
            for(Node nei : n.neighbors) {
                if(!visited.containsKey(nei)) {
                    visited.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                visited.get(n).neighbors.add(visited.get(nei));
            }
        }
        return visited.get(node);
    }

    // DFS
    public Node cloneGraphDfs(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        return dfs(visited, node);
    }

    Node dfs(Map<Node, Node> visited, Node node) {
        if (visited.containsKey(node)) {
            return null;
        }
    
        visited.put(node, new Node(node.val));
        for (Node nei: node.neighbors) {
            Node n = dfs(visited, nei);
            if(n != null) {
                visited.get(node).neighbors.add(n);
            }
        }
        return visited.get(node);
    }
}