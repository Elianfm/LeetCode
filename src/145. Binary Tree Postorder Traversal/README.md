# Binary Tree Postorder Traversal

## Problem Statement

Given the **root** of a binary tree, return the **postorder traversal** of its nodes' values.

**Postorder Traversal:**  
1. Visit the **left subtree**  
2. Visit the **right subtree**  
3. Visit the **root node**  

---

## Examples

### Example 1:

**Input:**  
```plaintext
root = [1,null,2,3]
```
**Output:**  
```plaintext
[3,2,1]
```
**Explanation:**  
```
    1
     \
      2
     /
    3
```
Postorder traversal: **Left → Right → Root** → `[3,2,1]`

---

### Example 2:

**Input:**  
```plaintext
root = [1,2,3,4,5,null,8,null,null,6,7,9]
```
**Output:**  
```plaintext
[4,6,7,5,2,9,8,3,1]
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
Postorder traversal: `[4,6,7,5,2,9,8,3,1]`

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

## Follow-up: Recursive solution is trivial, could you do it iteratively?
```