package main

import (
	"math"
	"slices"
)

func minEatingSpeed(piles []int, h int) int {
	l, r := 1, slices.Max(piles)
	response := 0

	for l <= r {
		mid := (l + r) / 2

		totalTime := 0
		for _, v := range piles {
			totalTime += int(math.Ceil(float64(v) / float64(mid)))
		}

		if totalTime <= h {
			response = mid
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return response
}
