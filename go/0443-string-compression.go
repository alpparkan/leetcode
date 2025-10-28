package main

import "strconv"

/*
https://leetcode.com/problems/string-compression
Difficulty: Medium
TC: O(n)
SC: O(1)
*/
func compress(chars []byte) int {
	n := len(chars)
	i := 0
	resI := 0

	for i < n {
		ch := chars[i]
		count := 0

		for i < n && chars[i] == ch {
			count++
			i++
		}

		if count > 0 {
			chars[resI] = ch
			resI++

			if count > 1 {
				digits := strconv.Itoa(count)
				for _, v := range digits {
					chars[resI] = byte(v)
					resI++
				}
			}
		}
	}
	return resI
}
