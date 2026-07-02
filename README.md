# 121. Best Time to Buy and Sell Stock

## 🟢 Difficulty
Easy

---

# 📖 Problem Statement

Imagine you want to buy a toy today and sell it later.

Every day, the toy has a different price.

Your goal is to:
- Buy the toy on **one day**
- Sell it on **a later day**
- Earn the **maximum profit**

If you cannot make any profit, return **0**.

---

## 📝 Example

### Input

```text
prices = [7,1,5,3,6,4]
```

### Output

```text
5
```

### Explanation

| Day | Price | Action |
|----|------|--------|
|1|7|Too expensive ❌|
|2|1|Buy here ✅|
|3|5|Profit = 4|
|4|3|Profit = 2|
|5|6|Profit = 5 ✅ Best|
|6|4|Profit = 3|

So,

- Buy at **1**
- Sell at **6**

Maximum Profit = **5**

---

# 💡 Thinking Like a Child

Imagine you are walking through a market.

Every shop tells you today's toy price.

While walking:

- Remember the **cheapest price** you've seen.
- Whenever you see a new price, ask:

> "If I had bought the toy at the cheapest price, how much money would I earn by selling it today?"

Keep checking every day.

Whenever you find a bigger profit, remember it.

That's it!

You never need to go back because you've already remembered the cheapest price.

---

# ❌ Brute Force Idea

A beginner might think:

"For every day, try buying the stock, then check every future day to sell it."

Example:

```
Buy on Day 1
    Sell Day 2
    Sell Day 3
    Sell Day 4
    ...

Buy on Day 2
    Sell Day 3
    Sell Day 4
    ...
```

This checks **every possible pair**.

### Time Complexity

```
O(n²)
```

### Space Complexity

```
O(1)
```

Although it works, it becomes very slow for large inputs.

---

# 🚀 Optimized Idea

Instead of checking every pair, we only remember two things:

### 1️⃣ Cheapest price so far

```
minBuy
```

### 2️⃣ Maximum profit so far

```
maxProfit
```

For every price:

- Calculate today's possible profit.

```
Today's Profit = Current Price - Cheapest Price
```

- Update the maximum profit if today's profit is better.
- Update the cheapest buying price if today's price is lower.

Repeat until the end.

---

# 🔍 Dry Run

```
prices = [7,1,5,3,6,4]
```

| Current Price | Cheapest Price | Profit | Best Profit |
|---------------|---------------|--------|-------------|
|7|7|0|0|
|1|1|0|0|
|5|1|4|4|
|3|1|2|4|
|6|1|5|5|
|4|1|3|5|

Final Answer:

```
5
```

---

# 🧠 Why This Works

At every step:

- We already know the cheapest day to buy.
- We only need to check whether selling today gives a better profit.

Instead of comparing every pair of days, we make **just one pass** through the array.

---

# ⚠️ Common Mistakes

❌ Selling before buying.

❌ Updating the minimum price after calculating profit incorrectly.

❌ Forgetting that if no profit is possible, the answer should be **0**.

❌ Initializing `minBuy` incorrectly.

---

# ⏱ Complexity Analysis

| Method | Time | Space |
|--------|------|-------|
|Brute Force|O(n²)|O(1)|
|Optimized|O(n)|O(1)|

---

# 🎯 Pattern Used

- Array
- Greedy
- One Pass Traversal

---

# 🌱 What I Learned

- Keep track of the smallest value seen so far.
- Update the answer while traversing the array.
- Sometimes remembering just a little information (the minimum value) can eliminate the need for nested loops.
- Greedy solutions often work when making the best local decision leads to the global optimum.

---

# 💻 Solution

The Java solution is available in **Solution.java**.
