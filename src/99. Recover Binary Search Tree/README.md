# Recover Binary Search Tree

## Problem Statement

You are given the **root** of a **Binary Search Tree (BST)** where **exactly two nodes** have been swapped by mistake. Your task is to **recover the tree** without changing its structure.

---

## Examples

### Example 1:

**Input:**  
```plaintext
root = [1,3,null,null,2]
```
**Output:**  
```plaintext
[3,1,null,null,2]
```
**Explanation:**  
- `3` cannot be a left child of `1` because `3 > 1`.  
- Swapping `1` and `3` makes the BST valid.

---

### Example 2:

**Input:**  
```plaintext
root = [3,1,4,null,null,2]
```
**Output:**  
```plaintext
[2,1,4,null,null,3]
```
**Explanation:**  
- `2` cannot be in the right subtree of `3` because `2 < 3`.  
- Swapping `2` and `3` makes the BST valid.

---

## Constraints

- The number of nodes in the tree is in the range **[2, 1000]**.
- The value of each node is in the range **[-2³¹, 2³¹ - 1]**.

---

## Follow-Up

- A solution using **O(n) space** (storing an inorder traversal) is straightforward.
- **Can you devise a solution using O(1) extra space?**
