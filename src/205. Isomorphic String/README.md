---

# Isomorphic Strings

## Problem Statement

Given two strings `s` and `t`, determine if they are **isomorphic**.

Two strings `s` and `t` are isomorphic if the characters in `s` can be replaced to get `t`.

- All occurrences of a character must be replaced with **another** character while preserving the order.
- No two characters may map to the same character, but a character **may** map to itself.

---

## Examples

### Example 1

**Input:**
```python
s = "egg"
t = "add"
```
**Output:**
```python
true
```
**Explanation:**  
- 'e' → 'a'  
- 'g' → 'd'  
- 'g' → 'd' (consistent mapping)

---

### Example 2

**Input:**
```python
s = "foo"
t = "bar"
```
**Output:**
```python
false
```
**Explanation:**  
- 'f' → 'b'  
- 'o' → 'a'  
- 'o' → 'r' (conflict: 'o' mapped to both 'a' and 'r')

---

### Example 3

**Input:**
```python
s = "paper"
t = "title"
```
**Output:**
```python
true
```
**Explanation:**  
- 'p' → 't'  
- 'a' → 'i'  
- 'p' → 't' (consistent mapping)  
- 'e' → 'l'  
- 'r' → 'e'

---

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `t.length == s.length`
- `s` and `t` consist of any valid ASCII character.

---
