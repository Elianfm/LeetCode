# House Robber

You are a **professional robber** planning to rob houses along a street. Each house has a certain amount of money stashed. However, adjacent houses have security systems connected, meaning **you cannot rob two adjacent houses on the same night**.

### Task:
Given an integer array `nums` representing the amount of money in each house, return the **maximum** amount of money you can rob tonight **without alerting the police**.

---

## Examples

### Example 1:
**Input:**  
```plaintext
nums = [1,2,3,1]
```
**Output:**  
```plaintext
4
```
**Explanation:**  
- Rob house **1** (`$1`) and house **3** (`$3`).
- Total amount robbed = **1 + 3 = 4**.

---

### Example 2:
**Input:**  
```plaintext
nums = [2,7,9,3,1]
```
**Output:**  
```plaintext
12
```
**Explanation:**  
- Rob house **1** (`$2`), house **3** (`$9`), and house **5** (`$1`).
- Total amount robbed = **2 + 9 + 1 = 12**.

---

## Constraints:
- `1 <= nums.length <= 100`
- `0 <= nums[i] <= 400`
