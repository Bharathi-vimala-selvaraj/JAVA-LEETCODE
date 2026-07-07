# 📈 Arithmetic Progression (AP) & Geometric Progression (GP)

> **Topics:** Arrays, Math, Sorting, Pattern Recognition

---

# 📖 What is AP?

An **Arithmetic Progression (AP)** is a sequence where the **difference** between consecutive numbers is always the same.

### Example

```text
2 4 6 8 10

Difference:
4-2 = 2
6-4 = 2
8-6 = 2
10-8 = 2
```

✅ Common Difference = **2**

---

# 📖 What is GP?

A **Geometric Progression (GP)** is a sequence where the **ratio** between consecutive numbers is always the same.

### Example

```text
5 10 20 40 80

Ratio:
10/5 = 2
20/10 = 2
40/20 = 2
80/40 = 2
```

✅ Common Ratio = **2**

---

# 🧠 Trick to Identify AP or GP

Always compare the **first two numbers**.

For AP

```java
int diff = arr[1] - arr[0];
```

For GP

```java
int ratio = arr[1] / arr[0];
```

Now verify the remaining elements.

---

# 🚀 Problem 1 : Can Make Arithmetic Progression

## 💡 Idea

The array may not be sorted.

Example

```text
3 5 1
```

Looks like **not AP**

But after sorting

```text
1 3 5
```

Difference

```text
2
2
```

It is an AP.

So,

> **Sort first, then check the difference.**

---

## 💻 Code

```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {

        Arrays.sort(arr);

        int d = arr[1] - arr[0];

        for (int i = 1; i < arr.length - 1; i++) {

            if (arr[i + 1] - arr[i] != d)
                return false;

        }

        return true;
    }
}
```

---

## 🔄 How it Works

Input

```text
5 3 1
```

After Sorting

```text
1 3 5
```

Difference

```text
3-1 = 2
5-3 = 2
```

Every difference is same.

Answer

```text
true
```

---

# 🚀 Problem 2 : Find the Next Number (AP or GP)

## 💡 Idea

1. Find the common difference.
2. Check whether every difference is equal.
3. If yes → AP.
4. Else → GP.

---

## 💻 Code

```java
int diff = arr[1] - arr[0];
boolean isAP = true;

for(int i=2;i<n;i++){
    if(arr[i]-arr[i-1]!=diff){
        isAP=false;
        break;
    }
}

if(isAP)
    System.out.println(arr[n-1]+diff);
else{
    int ratio=arr[1]/arr[0];
    System.out.println(arr[n-1]*ratio);
}
```

---

## 🔄 Example 1

```text
2 4 6 8
```

Difference

```text
2
2
2
```

AP

Next Number

```text
8+2=10
```

---

## 🔄 Example 2

```text
5 10 20 40 80
```

Difference

```text
5
10
20
40
```

Not Equal

Check Ratio

```text
2
2
2
2
```

GP

Next Number

```text
80×2=160
```

---

# 🎯 Tricks to Remember

## ✅ AP Trick

Think **Subtract**.

```text
Current - Previous
```

If every subtraction is same

➡ AP

---

## ✅ GP Trick

Think **Divide**.

```text
Current / Previous
```

If every division is same

➡ GP

---

## 🔥 Memory Hack

```
AP → Addition ➕
GP → Multiplication ✖️
```

or

```
AP → Difference

GP → Ratio
```

---

# 📝 Cheat Code

### Check AP

```java
int d = arr[1]-arr[0];

for(int i=1;i<arr.length-1;i++)
    if(arr[i+1]-arr[i]!=d)
        return false;
```

---

### Check GP

```java
int r = arr[1]/arr[0];

for(int i=1;i<arr.length-1;i++)
    if(arr[i+1]/arr[i]!=r)
        return false;
```

---

### Next AP Number

```java
last + difference
```

---

### Next GP Number

```java
last × ratio
```

---

# ⏱ Complexity

### Can Make Arithmetic Progression

- Time : **O(n log n)** (Sorting)
- Space : **O(1)**

---

### Find Next Number

- Time : **O(n)**
- Space : **O(n)**

---

# 🧩 Similar LeetCode Problems

| Problem | Pattern |
|---------|---------|
| 1502. Can Make Arithmetic Progression From Sequence | AP + Sorting |
| 70. Climbing Stairs | Sequence Pattern |
| 509. Fibonacci Number | Mathematical Sequence |
| 118. Pascal's Triangle | Sequence Generation |
| 119. Pascal's Triangle II | Mathematical Pattern |

---

# 🚀 30-Second Revision

```
AP
↓

Subtract

↓

Difference Same?

↓

Yes → AP

↓

Next = Last + Difference
```

```
GP
↓

Divide

↓

Ratio Same?

↓

Yes → GP

↓

Next = Last × Ratio
```

## 💎 Golden Rule

> **AP = Addition (Difference)**  
> **GP = Multiplication (Ratio)**

If you remember these two formulas, you can solve almost every basic AP/GP interview problem in minutes.
