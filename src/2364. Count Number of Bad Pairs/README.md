# Bad Pairs

## Problem Statement

You are given a **0-indexed** integer array `nums`. A pair of indices `(i, j)` is a **bad pair** if:

\[
i < j \quad \text{and} \quad j - i \neq nums[j] - nums[i]
\]

Return the total number of **bad pairs** in `nums`.

---

## Examples

### Example 1

**Input:**
```python
nums = [4,1,3,3]
```
**Output:**
```python
5
```

**Explanation:**
The bad pairs are:
- `(0, 1)`: \( 1 - 0 \neq 1 - 4 \) (1 ≠ -3)
- `(0, 2)`: \( 2 - 0 \neq 3 - 4 \) (2 ≠ -1)
- `(0, 3)`: \( 3 - 0 \neq 3 - 4 \) (3 ≠ -1)
- `(1, 2)`: \( 2 - 1 \neq 3 - 1 \) (1 ≠ 2)
- `(2, 3)`: \( 3 - 2 \neq 3 - 3 \) (1 ≠ 0)

Total **bad pairs**: `5`.

---

### Example 2

**Input:**
```python
nums = [1,2,3,4,5]
```
**Output:**
```python
0
```

**Explanation:**
There are **no** bad pairs.

---

## Constraints

- `1 <= nums.length <= 10⁵`
- `1 <= nums[i] <= 10⁹`