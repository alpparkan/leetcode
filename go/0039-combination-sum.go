package main

import "slices"

func combinationSum(candidates []int, target int) [][]int {
	var res [][]int
	var curr []int
	var currSum int

	combinationSum_backtrack(0, candidates, target, &currSum, &curr, &res)

	return res
}

func combinationSum_backtrack(index int, candidates []int, target int, currSum *int, curr *[]int, res *[][]int) {
	if *currSum == target {
		*res = append(*res, slices.Clone(*curr))
		return
	}
	if *currSum > target || (index < 0 || index >= len(candidates)) {
		return
	}

	// include same num again, duplicates are allowed
	*currSum += candidates[index]
	*curr = append(*curr, candidates[index])
	combinationSum_backtrack(index, candidates, target, currSum, curr, res)
	// backtrack, remove current num and include next one
	*currSum -= candidates[index]
	*curr = (*curr)[:len(*curr)-1]
	combinationSum_backtrack(index+1, candidates, target, currSum, curr, res)
}
