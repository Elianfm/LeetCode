# Maximum Sum of Pair With Equal Digit Sum

## Problem Statement

You are given a **0-indexed** array `nums` consisting of **positive integers**. You can choose two indices `i` and `j` such that `i != j`, and the **sum of digits** of `nums[i]` is equal to that of `nums[j]`.

Return the **maximum value** of `nums[i] + nums[j]` that you can obtain over all possible pairs `(i, j)` that satisfy the conditions. If no such pair exists, return `-1`.

---

## Examples

### Example 1:

**Input:**  
```plaintext
nums = [18,43,36,13,7]
```
**Output:**  
```plaintext
54
```
**Explanation:**  
Valid pairs with the same sum of digits:
- `(0,2)`: `18` (1+8 = **9**) and `36` (3+6 = **9**) → `18 + 36 = 54`
- `(1,4)`: `43` (4+3 = **7**) and `7` (7 = **7**) → `43 + 7 = 50`

The maximum sum is **54**.

---

### Example 2:

**Input:**  
```plaintext
nums = [10,12,19,14]
```
**Output:**  
```plaintext
-1
```
**Explanation:**  
No two numbers have the same sum of digits, so we return `-1`.

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
