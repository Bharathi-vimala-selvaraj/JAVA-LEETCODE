# 🧠 Elimination Game (LeetCode 390)

## 🚀 Approach (O(log n))

Instead of simulating the entire list (which would take **O(n)** time), this solution uses a mathematical observation to solve the problem in **O(log n)** time and **O(1)** space.

Rather than storing the remaining numbers, we only keep track of three variables:

| Variable | Description |
|----------|-------------|
| `head` | The first number in the current remaining sequence |
| `step` | Distance between consecutive remaining numbers (doubles every round: `1 → 2 → 4 → 8 ...`) |
| `left` | Direction of elimination (`1` = Left → Right, `0` = Right → Left) |

---

## 🔄 Algorithm

For every elimination round:

1. If we're eliminating **Left → Right**, the first element is always removed, so the `head` moves forward by `step`.

2. If we're eliminating **Right → Left**, the `head` moves **only when the remaining count is odd**.

3. After each round:
   - Half of the numbers are removed.
   - `step` doubles.
   - Direction flips.

```java
while (n > 1) {
    if (left == 1 || n % 2 == 1)
        head += step;

    step *= 2;
    n /= 2;
    left = 1 - left;
}
```

---

## 💡 Key Observation

> **The head moves only when going Left or when the remaining count is odd.**

### Why?

### ✅ Left → Right

The first element is always removed.

Example:

```
1 2 3 4 5 6
↓
2 4 6
```

The head changes from **1 → 2**.

---

### ✅ Right → Left (Even Count)

Example:

```
2 4 6 8
```

Removing from the right removes:

```
8,4
```

Remaining:

```
2 6
```

The head **does not change**.

---

### ✅ Right → Left (Odd Count)

Example:

```
2 4 6 8 10
```

Removing from the right removes:

```
10,6,2
```

Remaining:

```
4 8
```

The original head is removed, so the new head advances.

---

## 📝 Dry Run (n = 9)

Initial State

| head | step | left | n |
|------|------|------|---|
| 1 | 1 | Left | 9 |

### Round 1 (Left → Right)

```
head = 1 + 1 = 2
step = 2
n = 4
direction = Right
```

### Round 2 (Right → Left)

Remaining count is even, so head stays the same.

```
head = 2
step = 4
n = 2
direction = Left
```

### Round 3 (Left → Right)

```
head = 2 + 4 = 6
step = 8
n = 1
```

✅ **Answer = 6**

---

## ⏱️ Complexity

| Complexity | Value |
|------------|-------|
| Time | **O(log n)** |
| Space | **O(1)** |

---

## 🧩 Trick to Remember

> **Head moves only when:**
>
> - ✅ Eliminating **Left → Right**
> - ✅ Eliminating **Right → Left** **and** the remaining count is **odd**

Remember this single rule, and the entire algorithm becomes easy to derive.
