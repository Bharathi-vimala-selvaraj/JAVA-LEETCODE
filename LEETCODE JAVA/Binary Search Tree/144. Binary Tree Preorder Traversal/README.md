# 🌳 Preorder Traversal

## 🧠 Core Idea

**Preorder = Root → Left → Right**

```text
        1
       / \
      2   3
     / \
    4   5
```

Output:

```text
[1, 2, 4, 5, 3]
```

---

## 🔑 Logic

```text
1. If root == null → STOP
2. Add root.val
3. Traverse left
4. Traverse right
```

### Code Pattern

```java
if (root == null) {
    return;
}

a.add(root.val);        // ROOT
preorder(root.left, a); // LEFT
preorder(root.right, a);// RIGHT
```

---

## 🔄 Dry Run

For:

```text
        1
       / \
      2   3
     / \
    4   5
```

```text
1 → add 1
↓
2 → add 2
↓
4 → add 4
↓
null → return
↓
null → return
↓
5 → add 5
↓
3 → add 3
```

Result:

```text
[1, 2, 4, 5, 3]
```

---

## 📦 Why `List<Integer>`?

We need a place to store the traversal result.

```java
List<Integer> a = new ArrayList<>();
```

The **same list** is passed through every recursive call.

```java
preorder(root.left, a);
preorder(root.right, a);
```

---

## 🛑 Base Case

```java
if (root == null) {
    return;
}
```

No node → stop recursion.

This is what prevents infinite recursion.

---

## ⭐ Remember

```text
PREORDER
   ↓
ROOT → LEFT → RIGHT
   ↓
ADD → LEFT → RIGHT
```

### Interview Shortcut

When asked for preorder:

```java
if (root == null) return;

a.add(root.val);
preorder(root.left, a);
preorder(root.right, a);
```

---

## ⏱ Complexity

* **Time:** `O(n)` — every node is visited once.
* **Space:** `O(h)` recursion stack, where `h` is tree height.
* **Output list:** `O(n)`

---

## 💡 Key Takeaway

> **Preorder means: visit the node first, then go left, then go right.**
