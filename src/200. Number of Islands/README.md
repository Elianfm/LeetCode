# Number of Islands

## Problem Statement

Given an `m x n` **2D binary grid** `grid`, where:
- `'1'` represents **land**.
- `'0'` represents **water**.

Return the **number of islands**.

**Definition of an Island**:
- A group of `'1'`s (**land**) connected **horizontally** or **vertically**.
- An island is **surrounded by water**.
- You may assume that **all four edges** of the grid are **surrounded by water**.

---

## Examples

### Example 1

**Input:**
```python
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```
**Output:**
```python
1
```
---

### Example 2

**Input:**
```python
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```
**Output:**
```python
3
```
---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 300`
- `grid[i][j]` is **'0'** or **'1'**.

