# Alice and Bob Game

Alice and Bob take turns playing a game, with Alice starting first.

## Game Rules:
1. Initially, there is a number `n` on the chalkboard.
2. On each player's turn, they must:
   - Choose any `x` such that `0 < x < n` and `n % x == 0`.
   - Replace `n` with `n - x`.
3. If a player cannot make a move, they lose the game.

## Objective:
Return `true` if and only if Alice wins the game, assuming both players play optimally.

## Examples:

### Example 1:
**Input:**  
```plaintext
n = 2
```
**Output:**  
```plaintext
true
```
**Explanation:**  
- Alice chooses `1`, so `n` becomes `2 - 1 = 1`.
- Bob has no valid moves, so Alice wins.

### Example 2:
**Input:**  
```plaintext
n = 3
```
**Output:**  
```plaintext
false
```
**Explanation:**  
- Alice chooses `1`, so `n` becomes `3 - 1 = 2`.
- Bob chooses `1`, so `n` becomes `2 - 1 = 1`.
- Alice has no valid moves, so Bob wins.

## Constraints:
- `1 <= n <= 1000`