# Palindrome Number

## Problem Statement

Given an integer `x`, return `true` if `x` is a palindrome, and `false` otherwise.

An integer is a palindrome when it reads the same forward and backward.

---

## Examples

### Example 1

**Input:**
```python
x = 121
```

**Output:**
```python
true
```

**Explanation:**
`121` reads as `121` from left to right and from right to left.

---

### Example 2

**Input:**
```python
x = -121
```

**Output:**
```python
false
```

**Explanation:**
From left to right, it reads `-121`. From right to left, it becomes `121-`. Therefore, it is not a palindrome.

---

### Example 3

**Input:**
```python
x = 10
```

**Output:**
```python
false
```

**Explanation:**
Reads `01` from right to left. Therefore, it is not a palindrome.

---

## Constraints

- `-2^{31} <= x <= 2^{31} - 1`

---

## Follow-Up

Could you solve it without converting the integer to a string?