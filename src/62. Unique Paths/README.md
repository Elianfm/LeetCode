# Unique Paths

There is a robot on an `m x n` grid. The robot is initially located at the **top-left corner** (`grid[0][0]`). The goal is to move to the **bottom-right corner** (`grid[m - 1][n - 1]`). The robot can only move **down** or **right** at any point in time.

Given the two integers `m` and `n`, return the **number of unique paths** the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be **≤ 2 * 10^9**.

## Example 1:
![alt text](image.png)
**Input:**  
`m = 3, n = 7`  

**Output:**  
`28`  

## Example 2:

**Input:**  
`m = 3, n = 2`  

**Output:**  
`3`  

**Explanation:**  
From the **top-left** corner, there are a total of **3** ways to reach the **bottom-right** corner:
1. `Right → Down → Down`
2. `Down → Down → Right`
3. `Down → Right → Down`

## Constraints:

- `1 <= m, n <= 100`