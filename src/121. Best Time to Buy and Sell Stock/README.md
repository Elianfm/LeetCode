# Best Time to Buy and Sell Stock

## Problem Statement

You are given an array `prices` where `prices[i]` is the price of a given stock on the `i`-th day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different future day** to sell that stock.

Return the **maximum profit** you can achieve from this transaction. If you cannot achieve any profit, return `0`.

## Examples

### Example 1:
**Input:**
```plaintext
prices = [7,1,5,3,6,4]
```
**Output:**
```plaintext
5
```
**Explanation:**  
- Buy on **day 2** (price = `1`)  
- Sell on **day 5** (price = `6`)  
- Profit = `6 - 1 = 5`  
- **Note:** Buying on day 2 and selling on day 1 is not allowed since you must buy before you sell.

### Example 2:
**Input:**
```plaintext
prices = [7,6,4,3,1]
```
**Output:**
```plaintext
0
```
**Explanation:**  
No transactions are possible since prices are continuously decreasing. The maximum profit is `0`.

## Constraints
- `1 <= prices.length <= 10^5`
- `0 <= prices[i] <= 10^4`