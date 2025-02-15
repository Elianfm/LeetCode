# Product of the Last K Numbers

## Problem Statement

Design an algorithm that accepts a stream of integers and retrieves the product of the last `k` integers of the stream.

### Implement the `ProductOfNumbers` class:

- `ProductOfNumbers()` → Initializes the object with an empty stream.
- `void add(int num)` → Appends the integer `num` to the stream.
- `int getProduct(int k)` → Returns the **product of the last k numbers** in the current list.

**Assumptions:**
- The stream will always have at least `k` numbers when `getProduct(k)` is called.
- The product of any contiguous sequence of numbers will **fit into a 32-bit integer**.

---

## Examples

### Example 1:

**Input:**
```plaintext
["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
```

**Output:**
```plaintext
[null,null,null,null,null,null,20,40,0,null,32]
```

**Explanation:**
```java
ProductOfNumbers productOfNumbers = new ProductOfNumbers();
productOfNumbers.add(3);        // [3]
productOfNumbers.add(0);        // [3,0]
productOfNumbers.add(2);        // [3,0,2]
productOfNumbers.add(5);        // [3,0,2,5]
productOfNumbers.add(4);        // [3,0,2,5,4]
productOfNumbers.getProduct(2); // returns 20 (5 * 4)
productOfNumbers.getProduct(3); // returns 40 (2 * 5 * 4)
productOfNumbers.getProduct(4); // returns 0 (0 * 2 * 5 * 4)
productOfNumbers.add(8);        // [3,0,2,5,4,8]
productOfNumbers.getProduct(2); // returns 32 (4 * 8)
```

---

## Constraints

- `0 <= num <= 100`
- `1 <= k <= 4 * 10^4`
- At most **`4 * 10^4`** calls to `add` and `getProduct`.
- The product of the stream will **always fit into a 32-bit integer**.

---