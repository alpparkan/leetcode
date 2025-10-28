import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] p = prerequisites[i];
            prereq.computeIfAbsent(p[0], v -> new HashSet<>()).add(p[1]);
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (prereq.containsKey(i) && !dfs(prereq, visited, i)) {
                return false;
            }
        }
        return true;

    }

    boolean dfs(Map<Integer, Set<Integer>> prereq, Set<Integer> visited, int course) {
        if (visited.contains(course)) {
            return false;
        }

        visited.add(course);
        Set<Integer> prereqs = prereq.computeIfAbsent(course, v -> new HashSet<>());
        for (Integer p : prereqs) {
            if (!dfs(prereq, visited, p)) {
                return false;
            }
        }
        visited.remove(course);
        prereq.put(course, new HashSet<Integer>());
        return true;
    }
}