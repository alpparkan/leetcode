package main

import (
	"sort"
)

func topKFrequent(nums []int, k int) []int {
	counts := make(map[int]int, 0)
	for _, v := range nums {
		val, ok := counts[v]
		if !ok {
			val = 0
		}
		counts[v] = val + 1
	}

	countMap := make(map[int][]int)
	for num, count := range counts {
		val, ok := countMap[count]
		if !ok {
			val = []int{}
		}
		val = append(val, num)
		countMap[count] = val
	}

	keys := make([]int, 0, len(countMap))
	for k := range countMap {
		keys = append(keys, k)
	}
	sort.Sort(sort.Reverse(sort.IntSlice(keys)))

	// fmt.Printf("countMap: %v\n", countMap)
	// fmt.Printf("keys: %v\n", keys)

	res := []int{}
	for _, key := range keys {
		for _, n := range countMap[key] {
			res = append(res, n)

			if len(res) == k {
				return res
			}
		}
	}
	return res
}
