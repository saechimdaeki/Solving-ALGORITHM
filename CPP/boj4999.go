package main

import "fmt"

func main() {
	var a, b string
	count1 := 0
	count2 := 0
	fmt.Scanln(&a)
	fmt.Scanln(&b)
	var msg1 = "go"
	var msg2 = "no"
	for i := 0; i < len(a); i++ {
		if a[i] == 'a' {
			count1++
		}
	}
	for i := 0; i < len(b); i++ {
		if b[i] == 'a' {
			count2++
		}
	}
	if count1 >= count2 {
		fmt.Println(msg1)
	} else {
		fmt.Println(msg2)
	}
}
