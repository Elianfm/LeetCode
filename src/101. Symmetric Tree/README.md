# Symmetric Tree

## Problem Statement

Given the **root** of a **binary tree**, check whether it is a **mirror of itself** (i.e., symmetric around its center).

---

## Examples

### Example 1:
![alt text](image.png)
**Input:**  
```plaintext
root = [1,2,2,3,4,4,3]
```
**Output:**  
```plaintext
true
```
**Explanation:**  
The tree is symmetric because the left subtree is a mirror image of the right subtree.

---

### Example 2:
![alt text](image-1.png)
**Input:**  
```plaintext
root = [1,2,2,null,3,null,3]
```
**Output:**  
```plaintext
false
```
**Explanation:**  
The tree is **not** symmetric because the left and right subtrees do not mirror each other.

---

## Constraints

- `1 <= number of nodes <= 1000`
- `-100 <= Node.val <= 100`

---

## Follow-up:  Could you solve it both recursively and iteratively?