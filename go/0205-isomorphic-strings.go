package main

import "fmt"

/*
https://leetcode.com/problems/isomorphic-strings
Difficulty: Easy
TC: O(n)
SC: O(n)
*/
func isIsomorphic(s string, t string) bool {
	sMappings := make(map[byte]byte)
	tMappings := make(map[byte]byte)

	for i := range len(s) {
		ch_s, ch_t := s[i], t[i]

		if mapping, exists := sMappings[ch_s]; exists && mapping != ch_t {
			return false
		} else {
			sMappings[ch_s] = ch_t
		}

		if mapping, exists := tMappings[ch_t]; exists && mapping != ch_s {
			return false
		} else {
			tMappings[ch_t] = ch_s
		}
	}
	fmt.Printf("s mappings: %v\n", sMappings)
	fmt.Printf("t mappings: %v\n", tMappings)

	return true
}
