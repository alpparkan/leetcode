package main

type MinStack struct {
	stack  []int
	minVal []int
}

func Constructor() MinStack {
	s := make([]int, 0)
	minVal := make([]int, 0)

	return MinStack{s, minVal}
}

func (this *MinStack) Push(val int) {
	if len(this.minVal) == 0 || (len(this.minVal) > 0 && val <= this.minVal[len(this.minVal)-1]) {
		this.minVal = append(this.minVal, val)
	}
	this.stack = append(this.stack, val)
	// fmt.Printf("stack: [%v], minval: [%v]", this.stack, this.minVal)
}

func (this *MinStack) Pop() {
	if len(this.stack) > 0 {
		popped := this.stack[len(this.stack)-1]
		this.stack = this.stack[:len(this.stack)-1]

		if len(this.minVal) > 0 && this.minVal[len(this.minVal)-1] == popped {
			this.minVal = this.minVal[:len(this.minVal)-1]
		}
	}
}

func (this *MinStack) Top() int {
	if len(this.stack) > 0 {
		return this.stack[len(this.stack)-1]
	}
	return 0
}

func (this *MinStack) GetMin() int {
	if len(this.minVal) > 0 {
		return this.minVal[len(this.minVal)-1]
	}
	return 0
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
