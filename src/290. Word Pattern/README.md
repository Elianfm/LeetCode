---

# Word Pattern

## Problem Statement

Given a `pattern` and a string `s`, determine if `s` follows the same pattern.

**Rules:**
- Each letter in `pattern` maps to exactly **one unique word** in `s`.
- Each unique word in `s` maps to exactly **one letter** in `pattern`.
- No two letters map to the same word, and no two words map to the same letter.

---

## Examples

### Example 1

**Input:**
```python
pattern = "abba"
s = "dog cat cat dog"
```
**Output:**
```python
true
```

**Explanation:**
- `'a'` maps to `"dog"`
- `'b'` maps to `"cat"`
- The mapping is consistent throughout the string.

---

### Example 2

**Input:**
```python
pattern = "abba"
s = "dog cat cat fish"
```
**Output:**
```python
false
```
**Explanation:** The word `"fish"` does not match the expected pattern.

---

### Example 3

**Input:**
```python
pattern = "aaaa"
s = "dog cat cat dog"
```
**Output:**
```python
false
```
**Explanation:** The letter `'a'` is mapping to multiple words (`"dog"`, `"cat"`), which violates the rule.

---

## Constraints

- `1 <= pattern.length <= 300`
- `pattern` contains only **lowercase** English letters.
- `1 <= s.length <= 3000`
- `s` contains only **lowercase** English letters and **spaces `' '`**.
- `s` does **not** contain any **leading or trailing spaces**.
- All words in `s` are separated by **a single space**.

---