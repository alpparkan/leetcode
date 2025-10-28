import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prereq = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int[] p = prerequisites[i];
            prereq.computeIfAbsent(p[0], v -> new HashSet<>()).add(p[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (prereq.containsKey(i) && !dfs(prereq, cycle, visited, output, i)) {
                return new int[]{};
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    boolean dfs(Map<Integer, Set<Integer>> prereq, Set<Integer> cycle, Set<Integer> visited, List<Integer> output, int course) {
        if (cycle.contains(course)) {
            return false;
        }
        if(visited.contains(course)) {
            return true;
        }
        cycle.add(course);
        Set<Integer> prereqs = prereq.computeIfAbsent(course, v -> new HashSet<>());
        for (Integer p : prereqs) {
            if (!dfs(prereq, cycle, visited, output, p)) {
                return false;
            }
        }
        cycle.remove(course);
        visited.add(course);
        output.add(course);
        return true;
    }
}