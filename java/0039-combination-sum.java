import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int currSum = 0;

        dfs(candidates, target, res, curr, currSum, 0);
        return res;
    }

    void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> curr, int currSum, int i) {
        if (currSum == target) {
            res.add(List.copyOf(curr));
            return;
        }
        if (currSum > target || i < 0 || i >= candidates.length) {
            return;
        }

        curr.add(candidates[i]);
        currSum += candidates[i];
        dfs(candidates, target, res, curr, currSum, i);

        curr.remove(curr.size() - 1);
        currSum -= candidates[i];
        dfs(candidates, target, res, curr, currSum, i + 1);
    }
}