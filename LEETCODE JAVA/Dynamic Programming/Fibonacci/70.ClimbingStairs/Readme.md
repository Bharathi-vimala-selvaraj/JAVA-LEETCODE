# 🪜 Climbing Stairs (LeetCode 70)

> **Difficulty:** Easy  
> **Topics:** Dynamic Programming, Fibonacci, Iteration

## 💡 Intuition

To reach the **nth** stair, your last move must be either:

- From **(n-1)** using 1 step
- From **(n-2)** using 2 steps

So,

```text
ways(n) = ways(n-1) + ways(n-2)
```

This follows the **Fibonacci pattern**.

---

## 🔍 Observation

```text
n = 1 → 1
n = 2 → 2
n = 3 → 3
n = 4 → 5
n = 5 → 8
```

Each answer depends only on the previous two answers.

---

## 🚀 Approach

Instead of storing all values in a DP array, we only keep track of:

```text
a = ways(n-2)
b = ways(n-1)
```

For every new stair:

```text
current = a + b
a = b
b = current
```

This is a **sliding Fibonacci window**, giving **O(1)** space complexity.

---

## 💻 Code

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }
}
```

---

## 📊 Dry Run (`n = 5`)

| Step | a | b |
|------|---|---|
| Start | 1 | 2 |
| 3 | 2 | 3 |
| 4 | 3 | 5 |
| 5 | 5 | 8 |

**Answer = 8**

---

## ⏱ Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## 🎯 Trick to Remember

> **Current Answer = Previous Answer + Previous Previous Answer**

Whenever a problem asks for the number of ways to reach a destination with **1 or 2 moves**, think of the **Fibonacci/DP pattern**.

---

## 🧩 Similar Problems

- Fibonacci Number
- Min Cost Climbing Stairs
- House Robber
- House Robber II
- Unique Paths
- Decode Ways
