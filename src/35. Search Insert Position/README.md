# Search Insert Position

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

---

## Examples

### Example 1

**Input:**
```python
nums = [1,3,5,6]
target = 5
```

**Output:**
```python
2
```

---

### Example 2

**Input:**
```python
nums = [1,3,5,6]
target = 2
```

**Output:**
```python
1
```

---

### Example 3

**Input:**
```python
nums = [1,3,5,6]
target = 7
```

**Output:**
```python
4
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^4 <= nums[i] <= 10^4`
- `nums` contains distinct values sorted in ascending order.
- `-10^4 <= target <= 10^4`.
