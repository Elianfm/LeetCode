# Check If Two Binary Trees Are the Same

## Problem Statement

Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.

Two binary trees are considered the same if:
- They are **structurally identical**.
- The nodes have the **same value**.

---

## Examples

### Example 1:

**Input:**  
```plaintext
p = [1,2,3], q = [1,2,3]
```
**Output:**  
```plaintext
true
```
**Explanation:**  
Both trees have the same structure and node values.

---

### Example 2:

**Input:**  
```plaintext
p = [1,2], q = [1,null,2]
```
**Output:**  
```plaintext
false
```
**Explanation:**  
The structures of the trees are different.

---

### Example 3:

**Input:**  
```plaintext
p = [1,2,1], q = [1,1,2]
```
**Output:**  
```plaintext
false
```
**Explanation:**  
The structures are the same, but node values differ.

---

## Constraints

- The number of nodes in both trees is in the range **[0, 100]**.
- `-10^4 <= Node.val <= 10^4`.