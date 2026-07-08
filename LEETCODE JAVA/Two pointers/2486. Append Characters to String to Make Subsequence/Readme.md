# 🚀 Append Characters to String to Make Subsequence

> **Difficulty:** Medium  
> **Pattern:** Two Pointers • Greedy • Subsequence

---

## 📖 Problem Statement

Given two strings **`s`** and **`t`**, return the **minimum number of characters** that need to be appended to the **end** of `s` so that `t` becomes a **subsequence** of `s`.

---

## 💡 Core Idea

Instead of adding characters, first find **how much of `t` is already present** as a subsequence inside `s`.

The characters that **cannot be matched** are exactly the ones that must be appended.

---

## 🧠 Visualization

```
s = coaching
t = coding

c o a c h i n g
│ │
c o d i n g

Matched   : co
Remaining : ding

Answer = 4
```

---

## ⚡ Algorithm

```text
Start two pointers

Pointer 1 → s
Pointer 2 → t

While s is not finished
    If characters match
        Move both pointers
    Else
        Move only pointer of s

Remaining characters in t = Answer
```

---

## 🎯 Pointer Movement

| Situation | Move |
|-----------|------|
| ✅ Characters Match | Both pointers |
| ❌ Characters Don't Match | Only pointer of `s` |

---

## 🔍 Dry Run

### Example

```
s = abcde
t = acefg
```

| s Pointer | t Pointer | Match? |
|-----------|-----------|--------|
| a | a | ✅ |
| b | c | ❌ |
| c | c | ✅ |
| d | e | ❌ |
| e | e | ✅ |

Matched = **ace**

Remaining = **fg**

Answer = **2**

---

## 📝 Important Observations

- ✔ Order **must** be maintained.
- ✔ Characters **do not need to be adjacent**.
- ✔ Skip unnecessary characters in `s`.
- ✔ Never move the pointer of `t` unless a match occurs.
- ✔ Remaining unmatched characters are the answer.

---

## ❌ Common Mistakes

- Moving both pointers on a mismatch.
- Treating it like a substring problem.
- Forgetting that subsequences can skip characters.
- Counting matched characters incorrectly.

---

## 📊 Complexity Analysis

| Complexity | Value |
|------------|-------|
| ⏱ Time | **O(n)** |
| 💾 Space | **O(1)** |

---

## 🧩 Pattern Recognition

Whenever you see:

- "Subsequence"
- "Maintain Order"
- "Skip Characters"

👉 Think **Two Pointers**.

---

## 🧠 Interview Tip

Instead of asking:

> "What should I append?"

Ask:

> **"How much of the target string have I already matched?"**

Once you know that, the remaining characters automatically become the answer.

---

## 🌟 Key Takeaways

- Two pointers are enough.
- No extra data structures required.
- Traverse each string only once.
- Efficient and optimal solution.
- Great example of **Greedy + Two Pointers**.

---

## 🏷️ Tags

`Two Pointers` `Greedy` `Strings` `Subsequence` `LeetCode 2486`
