# Minimum Path Sum in a Triangle

## Problem Statement

Given a **triangle array**, return the **minimum path sum** from **top to bottom**.

At each step, you may move to **an adjacent number** in the row below. More formally, if you are at index `i` on the current row, you may move to either **index `i` or `i + 1`** in the next row.

---

## Examples

### Example 1

**Input:**
```python
triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
```
**Output:**
```python
11
```
**Explanation:**  
The triangle is:
```
   2
  3 4
 6 5 7
4 1 8 3
```
The minimum path sum is **2 + 3 + 5 + 1 = 11**.

---

### Example 2

**Input:**
```python
triangle = [[-10]]
```
**Output:**
```python
-10
```

---

## Constraints

- `1 <= triangle.length <= 200`
- `triangle[0].length == 1`
- `triangle[i].length == triangle[i - 1].length + 1`
- `-10⁴ <= triangle[i][j] <= 10⁴`

---

## Follow-up

Can you solve this using **O(n) extra space**, where `n` is the number of rows in the triangle?