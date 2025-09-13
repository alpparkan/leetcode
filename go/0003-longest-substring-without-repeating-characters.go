package main

func lengthOfLongestSubstring(s string) int {
	head, tail := 0, 0
	length := 0
	visited := make(map[byte]bool, 0)

	for head <= tail && tail < len(s) {
		if visited[s[tail]] {
			length = max(length, tail-head)
			visited = make(map[byte]bool, 0)

			head += 1
			visited[s[head]] = true
			tail = head + 1
		} else {
			visited[s[tail]] = true
			tail += 1
		}
	}
	length = max(length, tail-head)
	return length
}

func lengthOfLongestSubstring_Improved(s string) int {
	head, tail := 0, 0
	maxLength := 0
	visited := make(map[byte]bool, 0)

	for head <= tail && tail < len(s) {

		if !visited[s[tail]] {
			maxLength = max(maxLength, tail-head)
			for head <= tail {
				if s[head] == s[tail] {
					head += 1
					tail += 1
					break
				} else {
					delete(visited, s[head])
					head += 1
				}
			}
		} else {
			visited[s[tail]] = true
			tail += 1
		}
	}

	return max(maxLength, len(visited))
}
