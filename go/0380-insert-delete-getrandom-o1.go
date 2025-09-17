package main

import "math/rand"

/*
https://leetcode.com/problems/insert-delete-getrandom-o1
Difficulty: Mediun
TC: O(1)
SC: O(n)
*/

type RandomizedSet struct {
	numsMap  map[int]int
	numsList []int
}

func Constructor_380() RandomizedSet {
	return RandomizedSet{make(map[int]int, 0), make([]int, 0)}
}

func (this *RandomizedSet) Insert(val int) bool {
	_, ok := this.numsMap[val]
	if ok {
		return false
	}
	this.numsList = append(this.numsList, val)
	this.numsMap[val] = len(this.numsList) - 1

	return true
}

func (this *RandomizedSet) Remove(val int) bool {
	index, ok := this.numsMap[val]
	if !ok {
		return false
	}

	lastIndex := len(this.numsList) - 1
	lastElement := this.numsList[lastIndex]

	// Move last element to the position of element being removed
	this.numsList[index] = lastElement
	this.numsList = this.numsList[:lastIndex]

	// Update map to reflect new position of moved element
	this.numsMap[lastElement] = index

	delete(this.numsMap, val)
	return true
}

func (this *RandomizedSet) GetRandom() int {
	return this.numsList[rand.Intn(len(this.numsList))]
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Insert(val);
 * param_2 := obj.Remove(val);
 * param_3 := obj.GetRandom();
 */
