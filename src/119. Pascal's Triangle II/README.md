# Pascal's Triangle - Specific Row

## Problem Statement

Given an integer `rowIndex`, return the `rowIndex`-th (0-indexed) row of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

## Examples

### Example 1:
**Input:**
```plaintext
rowIndex = 3
```
**Output:**
```plaintext
[1,3,3,1]
```

### Example 2:
**Input:**
```plaintext
rowIndex = 0
```
**Output:**
```plaintext
[1]
```

### Example 3:
**Input:**
```plaintext
rowIndex = 1
```
**Output:**
```plaintext
[1,1]
```

## Constraints
- `0 <= rowIndex <= 33`

## Follow-up
Can you optimize your algorithm to use only **O(rowIndex)** extra space?
