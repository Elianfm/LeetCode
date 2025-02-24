# Contains Duplicate II

## Problem Statement

Given an integer array `nums` and an integer `k`, return `true` if there exist **two distinct indices** `i` and `j` in the array such that:

- `nums[i] == nums[j]`
- `abs(i - j) <= k`

Otherwise, return `false`.

---

## Examples

### Example 1:

**Input:**  
```plaintext
nums = [1,2,3,1], k = 3
```
**Output:**  
```plaintext
true
```
**Explanation:**  
There are two occurrences of `1` at indices `0` and `3`, and `abs(0 - 3) = 3 ≤ k`.

---

### Example 2:

**Input:**  
```plaintext
nums = [1,0,1,1], k = 1
```
**Output:**  
```plaintext
true
```
**Explanation:**  
There are two occurrences of `1` at indices `2` and `3`, and `abs(2 - 3) = 1 ≤ k`.

---

### Example 3:

**Input:**  
```plaintext
nums = [1,2,3,1,2,3], k = 2
```
**Output:**  
```plaintext
false
```
**Explanation:**  
Although there are duplicates, the minimum index difference is greater than `k`.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `0 <= k <= 10^5`
