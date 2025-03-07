# Remove All Occurrences of a Substring

## Problem Statement

Given two strings `s` and `part`, perform the following operation on `s` until all occurrences of the substring `part` are removed:

- Find the leftmost occurrence of the substring `part` and remove it from `s`.
- Return `s` after removing all occurrences of `part`.

A **substring** is a contiguous sequence of characters in a string.

---

## Examples

### Example 1:

**Input:**  
```plaintext
s = "daabcbaabcbc", part = "abc"
```
**Output:**  
```plaintext
"dab"
```
**Explanation:**  
The following operations are performed:
1. `s = "daabcbaabcbc"` → Remove `"abc"` at index `2` → `s = "dabaabcbc"`
2. `s = "dabaabcbc"` → Remove `"abc"` at index `4` → `s = "dababc"`
3. `s = "dababc"` → Remove `"abc"` at index `3` → `s = "dab"`

Now `s` has no occurrences of `"abc"`.

---

### Example 2:

**Input:**  
```plaintext
s = "axxxxyyyyb", part = "xy"
```
**Output:**  
```plaintext
"ab"
```
**Explanation:**  
The following operations are performed:
1. `s = "axxxxyyyyb"` → Remove `"xy"` at index `4` → `s = "axxxyyyb"`
2. `s = "axxxyyyb"` → Remove `"xy"` at index `3` → `s = "axxyyb"`
3. `s = "axxyyb"` → Remove `"xy"` at index `2` → `s = "axyb"`
4. `s = "axyb"` → Remove `"xy"` at index `1` → `s = "ab"`

Now `s` has no occurrences of `"xy"`.

---

## Constraints

- `1 <= s.length <= 1000`
