# Trie (Prefix Tree) Implementation

## Problem Statement

A **Trie** (pronounced "try") or **prefix tree** is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. This structure is commonly used in applications like **autocomplete** and **spell checking**.

### Implement the `Trie` class:
- `Trie()` → Initializes the trie object.
- `void insert(String word)` → Inserts the string `word` into the trie.
- `boolean search(String word)` → Returns `true` if `word` is in the trie, `false` otherwise.
- `boolean startsWith(String prefix)` → Returns `true` if there is any word in the trie that starts with `prefix`, `false` otherwise.

---

## Examples

### Example 1:

**Input:**
```plaintext
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
```

**Output:**
```plaintext
[null, null, true, false, true, null, true]
```

**Explanation:**
```java
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
```

---

## Constraints

- `1 <= word.length, prefix.length <= 2000`
- `word` and `prefix` consist only of **lowercase English letters**.
- **At most** `3 * 10^4` calls will be made to `insert`, `search`, and `startsWith`.