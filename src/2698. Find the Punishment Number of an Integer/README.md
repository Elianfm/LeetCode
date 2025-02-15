# Punishment Number of n

## Problem Statement

Given a **positive integer** `n`, return the **punishment number** of `n`.

The **punishment number** of `n` is defined as the **sum of the squares** of all integers `i` such that:

1. `1 <= i <= n`
2. The decimal representation of `i * i` can be partitioned into contiguous substrings such that the **sum of the integer values** of these substrings equals `i`.

---

## Examples

### Example 1:

**Input:**  
```plaintext
n = 10
```
**Output:**  
```plaintext
182
```
**Explanation:**  
Valid integers `i` that satisfy the conditions:
- `1`: `1 * 1 = 1` → ✅
- `9`: `9 * 9 = 81` → `8 + 1 = 9` ✅
- `10`: `10 * 10 = 100` → `10 + 0 = 10` ✅

Thus, the punishment number is:  
`1 + 81 + 100 = 182`.

---

### Example 2:

**Input:**  
```plaintext
n = 37
```
**Output:**  
```plaintext
1478
```
**Explanation:**  
Valid integers `i` that satisfy the conditions:
- `1`: `1 * 1 = 1` ✅
- `9`: `9 * 9 = 81` → `8 + 1 = 9` ✅
- `10`: `10 * 10 = 100` → `10 + 0 = 10` ✅
- `36`: `36 * 36 = 1296` → `1 + 29 + 6 = 36` ✅

Thus, the punishment number is:  
`1 + 81 + 100 + 1296 = 1478`.

---

## Constraints

- `1 <= n <= 1000`