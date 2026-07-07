# 🔀 Zigzag Conversion (LeetCode 6)

> **Difficulty:** Medium  
> **Topics:** Simulation, String, Matrix Traversal

---

# 📖 Problem

Write the characters of a string in a zigzag pattern across `numRows`, then read the rows one by one.

### Example

```text
Input:
s = "PAYPALISHIRING"
numRows = 3

Pattern:

P   A   H   N
A P L S I I G
Y   I   R

Output:
"PAHNAPLSIIGYIR"
```

---

# 💡 How This Solution Works

Instead of creating a matrix, create one string for each row.

```text
Row 0 -> ""
Row 1 -> ""
Row 2 -> ""
```

Traverse every character and place it into the current row.

Move:

- ⬇ Down until the last row.
- ⬆ Up until the first row.
- Repeat.

Finally, join all rows together.

---

# 🔄 Iteration

Example:

```text
s = "PAYPAL"
rows = 3
```

| Character | Row |
|-----------|-----|
| P | 0 |
| A | 1 |
| Y | 2 |
| P | 1 |
| A | 0 |
| L | 1 |

Rows become

```text
Row0 : PA
Row1 : APL
Row2 : Y
```

Answer

```text
PAAPLY
```

---

# 🔑 Key Snippets to Remember

### Create rows

```java
String[] rows = new String[numRows];
```

Initialize

```java
for(int i=0;i<numRows;i++)
    rows[i]="";
```

---

### Edge Case

```java
if(numRows==1)
    return s;
```

---

### Change Direction

```java
if(i==0 || i==numRows-1)
    down = !down;
```

---

### Move Pointer

```java
i += down ? 1 : -1;
```

---

### Add Character

```java
rows[i] += s.charAt(j);
```

---

### Merge All Rows

```java
for(String row : rows)
    ans += row;
```

---

# 🧠 Cheat Code

Think of a person walking on stairs.

```text
0
↓
1
↓
2
↑
1
↑
0
↓
1
↓
2
```

Only the **direction changes**.

Remember these two lines:

```java
if(i==0 || i==numRows-1)
    down = !down;

i += down ? 1 : -1;
```

That's the entire algorithm.

---

# ⏱ Complexity

- **Time:** O(n)
- **Space:** O(n)

---

# 🧩 Similar Problems

- LeetCode 54 – Spiral Matrix
- LeetCode 59 – Spiral Matrix II
- LeetCode 498 – Diagonal Traverse
- LeetCode 885 – Spiral Matrix III
- LeetCode 344 – Reverse String
- LeetCode 151 – Reverse Words in a String

---

# 🎯 Shortcut to Remember

```
Create rows

↓

Walk Down

↓

Walk Up

↓

Repeat

↓

Join all rows
```

**Pattern:**

```
⬇⬇⬇⬆⬆⬆⬇⬇⬇⬆⬆⬆
```

If you can remember **"move, flip direction at the first/last row, repeat"**, you can solve this problem in under 5 minutes.
