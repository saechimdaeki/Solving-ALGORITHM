package main

import (
	"bufio"
	"fmt"
	"os"
)

var bufin *bufio.Reader = bufio.NewReader(os.Stdin)
var bufout *bufio.Writer = bufio.NewWriter(os.Stdout)
var n int
var grid [101][101]int
var paper [101][101]int
var visited [101][101]bool

func Max(x int, y int) int {
	if x < y {
		return y
	}
	return x
}
func dopy(h int) {
	for i := 0; i <= 100; i++ {
		for j := 0; j <= 100; j++ {
			visited[i][j] = false
		}
	}
	for i := 0; i <= 100; i++ {
		for j := 0; j <= 100; j++ {
			paper[i][j] = 0
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] > h {
				paper[i][j] = grid[i][j]
			}
		}
	}
}

func dfs(y int, x int) {
	visited[y][x] = true
	dy := []int{1, 0, -1, 0}
	dx := []int{0, -1, 0, 1}
	for i := 0; i < 4; i++ {
		cy := y + dy[i]
		cx := x + dx[i]
		if 0 <= cy && cy < n && 0 <= cx && cx < n {
			if visited[cy][cx] == false && paper[cy][cx] >= 1 {
				dfs(cy, cx)
			}
		}
	}
}

func main() {
	defer bufout.Flush()
	fmt.Fscan(bufin, &n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			fmt.Fscan(bufin, &grid[i][j])
		}
	}
	answer := 1
	for k := 1; k <= 100; k++ {
		dopy(k)
		cnt := 0
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				if visited[i][j] == false && paper[i][j] >= 1 {
					dfs(i, j)
					cnt++
				}
			}
		}
		answer = Max(answer, cnt)
	}
	fmt.Fprintf(bufout, "%d", answer)
}
