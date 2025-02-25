# Bomb Defusal: Decrypt the Code

You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length `n` and a key `k`.

## Decryption Rules

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously based on the following rules:

- If `k > 0`, replace the `i`th number with the sum of the next `k` numbers.
- If `k < 0`, replace the `i`th number with the sum of the previous `|k|` numbers.
- If `k == 0`, replace the `i`th number with `0`.

Since the code is circular:
- The next element of `code[n-1]` is `code[0]`.
- The previous element of `code[0]` is `code[n-1]`.

## Examples

### Example 1
**Input:**
```plaintext
code = [5,7,1,4], k = 3
```
**Output:**
```plaintext
[12,10,16,13]
```
**Explanation:**  
Each number is replaced by the sum of the next 3 numbers.  
Decrypted code: `[7+1+4, 1+4+5, 4+5+7, 5+7+1]`.  
Numbers wrap around in a circular manner.

---

### Example 2
**Input:**
```plaintext
code = [1,2,3,4], k = 0
```
**Output:**
```plaintext
[0,0,0,0]
```
**Explanation:**  
Since `k == 0`, all numbers are replaced with `0`.

---

### Example 3
**Input:**
```plaintext
code = [2,4,9,3], k = -2
```
**Output:**
```plaintext
[12,5,6,13]
```
**Explanation:**  
The decrypted code is computed as follows:
- `code[0]` = `3 + 9`
- `code[1]` = `2 + 3`
- `code[2]` = `4 + 2`
- `code[3]` = `9 + 4`

Numbers wrap around for negative `k`.

---

## Constraints

- `n == code.length`
- `1 <= n <= 100`
- `1 <= code[i] <= 100`
- `-(n - 1) <= k <= n - 1`
