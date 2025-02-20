```md
# Path Sum II

## Problem Statement

Given the `root` of a binary tree and an integer `targetSum`, return **all root-to-leaf paths** where the sum of the node values in the path equals `targetSum`. Each path should be returned as a list of node values, **not node references**.

A **root-to-leaf path** starts from the root and ends at any leaf node.  
A **leaf** is a node with no children.

---

## Examples

### Example 1:
![alt text](image.png)
**Input:**  
```plaintext
root = [5,4,8,11,null,13,4,7,2,null,null,5,1]
targetSum = 22
```
**Output:**  
```plaintext
[[5,4,11,2],[5,8,4,5]]
```
**Explanation:**  
There are two paths whose sum equals `targetSum`:
- `5 + 4 + 11 + 2 = 22`
- `5 + 8 + 4 + 5 = 22`

---

### Example 2:
![alt text](image-1.png)
**Input:**  
```plaintext
root = [1,2,3]
targetSum = 5
```
**Output:**  
```plaintext
[]
```
**Explanation:**  
There are no root-to-leaf paths with sum `5`.

---

### Example 3:

**Input:**  
```plaintext
root = [1,2]
targetSum = 0
```
**Output:**  
```plaintext
[]
```
**Explanation:**  
There are no root-to-leaf paths with sum `0`.

---

## Constraints

- The number of nodes in the tree is in the range `[0, 5000]`.
- `-1000 <= Node.val <= 1000`
- `-1000 <= targetSum <= 1000`
```