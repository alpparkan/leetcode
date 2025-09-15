package main

import "fmt"

// Time complexity: O(n1+n2).Since we have this sanity check on line 10, complexity is practically O(n2)
// Space complexity: O(1)
func checkInclusion(s1 string, s2 string) bool {
	var freqS1 [26]int
	var freqS2 [26]int
	n1, n2 := len(s1), len(s2)
	if n1 > n2 {
		return false
	}

	// here we build the counts for s1 and also first window of s2
	for i := 0; i < n1; i++ {
		freqS1[s1[i]-'a']++
		freqS2[s2[i]-'a']++
	}
	fmt.Printf("freqS1: %v\n", freqS1)
	fmt.Printf("freqS2: %v\n", freqS2)
	if freqS1 == freqS2 {
		return true
	}

	for i := n1; i < n2; i++ {
		freqS2[s2[i]-'a']++
		freqS2[s2[i-n1]-'a']--
		if freqS1 == freqS2 {
			return true
		}
	}
	return false
}
