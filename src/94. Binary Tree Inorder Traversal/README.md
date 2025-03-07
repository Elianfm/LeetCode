# Binary Tree Inorder Traversal

## Problem Statement

Given the **root** of a binary tree, return the **inorder traversal** of its nodes' values.

**Inorder Traversal:**  
- Visit the **left subtree**  
- Visit the **root node**  
- Visit the **right subtree**  

---

## Examples

### Example 1:

**Input:**  
```plaintext
root = [1,null,2,3]
```
**Output:**  
```plaintext
[1,3,2]
```
**Explanation:**  
```
    1
     \
      2
     /
    3
```
Inorder traversal: **Left → Root → Right** → `[1, 3, 2]`

---

### Example 2:

**Input:**  
```plaintext
root = [1,2,3,4,5,null,8,null,null,6,7,9]
```
**Output:**  
```plaintext
[4,2,6,5,7,1,3,9,8]
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
Inorder traversal: `[4, 2, 6, 5, 7, 1, 3, 9, 8]`

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