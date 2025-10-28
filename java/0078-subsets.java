import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, nums, subset, res);
        return res;
    }

    void dfs(int i, int[] nums, List<Integer> subset, List<List<Integer>> res) {
        // if i is out of bounds
        if (i == nums.length) {
            res.add(List.copyOf(subset));
            return;
        }

        subset.add(nums[i]);
        dfs(i + 1, nums, subset, res);
        
        subset.remove(subset.size() - 1);
        dfs(i + 1, nums, subset, res);
    }
}