# Word Search in a Grid

## Problem Statement

Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid.

- The word can be constructed from **sequentially adjacent** cells.
- **Adjacent cells** are horizontally or vertically neighboring.
- **The same letter cell may not be used more than once** in a word.

---

## Examples

### Example 1:
![alt text](image.png)
**Input:**  
```plaintext
board = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
]
word = "ABCCED"
```
**Output:**  
```plaintext
true
```

---

### Example 2:
![alt text](image-1.png)
**Input:**  
```plaintext
board = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
]
word = "SEE"
```
**Output:**  
```plaintext
true
```

---

### Example 3:
![alt text](image-2.png)
**Input:**  
```plaintext
board = [
  ["A","B","C","E"],
  ["S","F","C","S"],
  ["A","D","E","E"]
]
word = "ABCB"
```
**Output:**  
```plaintext
false
```

---

## Constraints

- `m == board.length`
- `n == board[i].length`
- `1 <= m, n <= 6`
- `1 <= word.length <= 15`
- `board` and `word` consist of **only** uppercase and lowercase English letters.

---

## Follow-Up
Could you use search pruning to make your solution faster with a larger board?
```