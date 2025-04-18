# Problem Statement

You are given an integer array `nums` and two integers `indexDiff` and `valueDiff`.

Find a pair of indices `(i, j)` such that:

- `i != j`
- `abs(i - j) <= indexDiff`
- `abs(nums[i] - nums[j]) <= valueDiff`

Return `true` if such a pair exists, or `false` otherwise.

## Examples

### Example 1:
**Input:**
```plaintext
nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
```
**Output:**
```plaintext
true
```
**Explanation:**  
We can choose `(i, j) = (0, 3)`.  
We satisfy the three conditions:
- `i != j` → `0 != 3`
- `abs(i - j) <= indexDiff` → `abs(0 - 3) <= 3`
- `abs(nums[i] - nums[j]) <= valueDiff` → `abs(1 - 1) <= 0`

### Example 2:
**Input:**
```plaintext
nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
```
**Output:**
```plaintext
false
```
**Explanation:**  
After trying all possible pairs `(i, j)`, we cannot satisfy the three conditions, so we return `false`.

## Constraints
- `2 <= nums.length <= 10^5`
- `-10^9 <= nums[i] <= 10^9`
- `1 <= indexDiff <= nums.length`
- `0 <= valueDiff <= 10^9`
