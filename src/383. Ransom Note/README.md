# Ransom Note

## Problem Statement

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.

---

## Examples

### Example 1

**Input:**
```python
ransomNote = "a"
magazine = "b"
```

**Output:**
```python
false
```

---

### Example 2

**Input:**
```python
ransomNote = "aa"
magazine = "ab"
```

**Output:**
```python
false
```

---

### Example 3

**Input:**
```python
ransomNote = "aa"
magazine = "aab"
```

**Output:**
```python
true
```

---

## Constraints

- `1 <= ransomNote.length, magazine.length <= 10^5`
- `ransomNote` and `magazine` consist of lowercase English letters.
