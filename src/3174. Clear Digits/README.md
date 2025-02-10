# Remove All Digits

## Problem Statement

You are given a string `s`.

Your task is to remove all digits by performing the following operation **repeatedly**:

- Delete the **first** digit and the **closest** non-digit character to its **left**.

Return the resulting string after **removing all digits**.

---

## Examples

### Example 1

**Input:**
```python
s = "abc"
```
**Output:**
```python
"abc"
```

**Explanation:**  
There are **no digits** in the string.

---

### Example 2

**Input:**
```python
s = "cb34"
```
**Output:**
```python
""
```

**Explanation:**  
1. The **first digit** is `'3'`, and the **closest non-digit** to its left is `'b'`, so we remove `'3'` and `'b'`.  
   New string: `"c4"`
2. The **next digit** is `'4'`, and the **closest non-digit** to its left is `'c'`, so we remove `'4'` and `'c'`.  
   New string: `""`

---

## Constraints

- `1 <= s.length <= 100`
- `s` consists **only** of lowercase English letters and digits.
- The input is generated such that it is **possible** to delete all digits.