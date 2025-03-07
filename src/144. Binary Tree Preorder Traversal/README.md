# Binary Tree Preorder Traversal

## Problem Statement

Given the **root** of a binary tree, return the **preorder traversal** of its nodes' values.

**Preorder Traversal:**  
1. Visit the **root node**  
2. Visit the **left subtree**  
3. Visit the **right subtree**  

---

## Examples

### Example 1:

**Input:**  
```plaintext
root = [1,null,2,3]
```
**Output:**  
```plaintext
[1,2,3]
```
**Explanation:**  
```
    1
     \
      2
     /
    3
```
Preorder traversal: **Root → Left → Right** → `[1,2,3]`

---

### Example 2:

**Input:**  
```plaintext
root = [1,2,3,4,5,null,8,null,null,6,7,9]
```
**Output:**  
```plaintext
[1,2,4,5,6,7,3,8,9]
```
**Explanation:**  
```
        1
       / \
      2   3
     / \   \
    4   5   8
       / \  /
      6   7 9
```
Preorder traversal: `[1,2,4,5,6,7,3,8,9]`

---

### Example 3:

**Input:**  
```plaintext
root = []
```
**Output:**  
```plaintext
[]
```

---

### Example 4:

**Input:**  
```plaintext
root = [1]
```
**Output:**  
```plaintext
[1]
```

---

## Constraints

- The number of nodes in the tree is in the range **[0, 100]**.
- `-100 <= Node.val <= 100`.

---

## Follow-up

Follow up: Recursive solution is trivial, could you do it iteratively?