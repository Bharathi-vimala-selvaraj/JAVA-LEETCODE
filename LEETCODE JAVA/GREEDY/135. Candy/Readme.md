# 🍬 Candy (LeetCode 135)

## 🧠 Key Idea

Each child must receive:

* At least **1 candy**
* More candies than an adjacent child **only if** they have a higher rating.

A single left-to-right or right-to-left pass is **not enough** because increasing sequences and decreasing sequences need to be handled independently.

The solution performs **two passes**:

1. **Left → Right** → Handle increasing ratings.
2. **Right → Left** → Handle decreasing ratings.

Finally, choose the **maximum candies required from both directions** for every child.

---

# 💡 Core Logic

```
Left Pass
Higher than left neighbour?
        │
      Yes ───► Previous Candy + 1
        │
      No ───► 1
```

```
Right Pass
Higher than right neighbour?
        │
      Yes ───► Next Candy + 1
        │
      No ───► 1
```

```
Final Candy for each child

max(left[i], right[i])
```

---

# 🚀 Step 1 — Left to Right

Maintain an array storing the minimum candies required considering only the **left neighbour**.

### Logic

```
rating[i] > rating[i-1]
        ↓
left[i] = left[i-1] + 1

Otherwise

left[i] = 1
```

### Snippet

```java
l[0] = 1;

for (int i = 1; i < n; i++) {
    if (ratings[i] > ratings[i - 1])
        lc++;
    else
        lc = 1;

    l[i] = lc;
}
```

---

# 🚀 Step 2 — Right to Left

Now satisfy the **right neighbour** condition.

### Logic

```
rating[i] > rating[i+1]
        ↓
right[i] = right[i+1] + 1

Otherwise

right[i] = 1
```

### Snippet

```java
r[n - 1] = 1;

for (int i = n - 2; i >= 0; i--) {
    if (ratings[i] > ratings[i + 1])
        rc++;
    else
        rc = 1;

    r[i] = rc;
}
```

---

# 🚀 Step 3 — Combine Both Passes

A child must satisfy **both** left and right conditions.

So take the maximum.

### Snippet

```java
for (int i = 0; i < n; i++) {
    s += Math.max(l[i], r[i]);
}
```

---

# 📊 Dry Run

```
Ratings

[1,0,2]
```

### Left Pass

```
1 0 2
↓

1 1 2
```

### Right Pass

```
1 0 2
↓

2 1 1
```

### Final

```
max(1,2) = 2
max(1,1) = 1
max(2,1) = 2

Result

[2,1,2]

Total = 5
```

---

# 📊 Another Example

```
Ratings

[1,2,2]
```

### Left

```
1 2 1
```

### Right

```
1 1 1
```

### Final

```
1 2 1

Total = 4
```

---

# ⚡ Why `Math.max()`?

The left pass only guarantees:

* Higher than the **left** neighbour.

The right pass only guarantees:

* Higher than the **right** neighbour.

Some children belong to **both** increasing and decreasing sequences, so we must satisfy both constraints.

```java
Math.max(l[i], r[i])
```

ensures the child gets enough candies for both directions.

---

# ⏱ Complexity

| Operation  | Complexity |
| ---------- | ---------- |
| Left Pass  | O(n)       |
| Right Pass | O(n)       |
| Final Sum  | O(n)       |
| **Total**  | **O(n)**   |

### Space Complexity

```
O(n)

Left Array
+
Right Array
```

---

# 🔑 Key Takeaways

* Initialize every child with **1 candy**.
* Use **two passes** because one direction alone cannot satisfy both neighbour constraints.
* Left pass handles increasing ratings.
* Right pass handles decreasing ratings.
* Use `Math.max(left[i], right[i])` to satisfy both conditions.
* This is an optimal **O(n)** solution.

---

## 📝 Logic in One Line

> **Compute the minimum candies needed from the left, compute the minimum candies needed from the right, then assign each child the larger of the two values and sum the result.**
