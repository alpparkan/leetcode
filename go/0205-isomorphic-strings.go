package main

import "fmt"

/*
https://leetcode.com/problems/isomorphic-strings
Difficulty: Easy
TC: O(n)
SC: O(n)
*/
func isIsomorphic(s string, t string) bool {
	mapS2T := make(map[byte]byte, 0)
	mapT2S := make(map[byte]byte, 0)

	for i := range len(s) {
		s_ch, t_ch := s[i], t[i]

		s_ch_val, s_ch_exist := mapS2T[s_ch]
		if s_ch_exist && s_ch_val != t_ch {
			return false
		} else {
			mapS2T[s_ch] = t_ch
		}

		t_ch_val, tExist := mapT2S[t_ch]
		if tExist && t_ch_val != s_ch {
			return false
		} else {
			mapT2S[t_ch] = s_ch
		}
	}
	fmt.Printf("mapS2T: %v\n", mapS2T)
	fmt.Printf("mapT2S: %v\n", mapT2S)

	return true
}
