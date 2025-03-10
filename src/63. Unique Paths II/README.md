```md
# Unique Paths with Obstacles

You are given an `m x n` integer array `grid`. A robot is initially located at the top-left corner (`grid[0][0]`). The robot tries to move to the bottom-right corner (`grid[m - 1][n - 1]`). It can only move **down** or **right** at any point in time.

An **obstacle** is marked as `1`, and an open space is marked as `0`. The robot **cannot** pass through obstacles.

Return the number of unique paths the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer is **≤ 2 * 10⁹**.

---

## Example 1:
![alt text](image.png)
**Input:**  
`obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]`  

**Output:**  
`2`

**Explanation:**  
There is one obstacle in the middle of the `3x3` grid.  
There are two ways to reach the bottom-right corner:
1. `Right -> Right -> Down -> Down`
2. `Down -> Down -> Right -> Right`

---

## Example 2:
![alt text](image-1.png)
**Input:**  
`obstacleGrid = [[0,1],[0,0]]`  

**Output:**  
`1`

---

## Constraints:

- `m == obstacleGrid.length`
- `n == obstacleGrid[i].length`
- `1 <= m, n <= 100`
- `obstacleGrid[i][j]` is `0` or `1`.
```