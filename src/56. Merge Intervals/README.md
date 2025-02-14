# Merge Overlapping Intervals

## Problem Statement

Given an array of **intervals**, where `intervals[i] = [start_i, end_i]`, merge all overlapping intervals and return an array of the **non-overlapping intervals** that cover all the intervals in the input.

---

## Examples

### Example 1:

**Input:**  
```plaintext
intervals = [[1,3],[2,6],[8,10],[15,18]]
```
**Output:**  
```plaintext
[[1,6],[8,10],[15,18]]
```
**Explanation:**  
- The intervals `[1,3]` and `[2,6]` **overlap**, so they merge into `[1,6]`.
- The other intervals do not overlap.

---

### Example 2:

**Input:**  
```plaintext
intervals = [[1,4],[4,5]]
```
**Output:**  
```plaintext
[[1,5]]
```
**Explanation:**  
- The intervals `[1,4]` and `[4,5]` **overlap**, so they merge into `[1,5]`.

---

## Constraints

- `1 <= intervals.length <= 10^4`
- `intervals[i].length == 2`
- `0 <= start_i <= end_i <= 10^4`
