# 🗑️ Remove Element (LeetCode 27)

> **Topics:** Two Pointers, Arrays, In-Place Algorithm

## 💡 Intuition

We don't need to remove elements physically.

Instead, **copy every valid element to the front of the array**.

Think of it as **filtering** the array in-place.

---

## 🚀 Approach

Use two pointers:

- **`i`** → Reads every element.
- **`j`** → Writes only the elements we want to keep.

Whenever the current element is **not equal** to `val`:

```java
nums[j] = nums[i];
j++;
```

At the end, `j` represents the number of valid elements.

---

## 🔄 Dry Run

Input

```text
nums = [3,2,2,3]
val = 3
```

| Read (`i`) | Write (`j`) | Action |
|------------|-------------|--------|
| 3 | 0 | Skip |
| 2 | 0 | Copy → j++ |
| 2 | 1 | Copy → j++ |
| 3 | 2 | Skip |

Final array:

```text
[2,2,...]
```

Return:

```text
2
```

---

## 🔑 Key Snippets

**Keep valid elements**

```java
if(nums[i] != val)
```

**Overwrite**

```java
nums[j] = nums[i];
```

**Move write pointer**

```java
j++;
```

**Answer**

```java
return j;
```

---

## 🧠 Trick to Remember

```
Read Everything

↓

Keep Valid

↓

Overwrite Front

↓

Return Count
```

Or simply:

> **Read with `i`, Write with `j`.**

---

## ⏱ Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## 🧩 Similar Problems

- Remove Duplicates from Sorted Array
- Move Zeroes
- Remove Duplicates from Sorted Array II
- Sort Array By Parity
- Merge Sorted Array

---

## 💎 Cheat Sheet

```
i → Read

j → Write

Valid?

↓

Copy

↓

j++
```

Whenever a problem asks you to **remove**, **filter**, or **compact** an array **without using extra space**, think **Two Pointers (Read & Write)**.
