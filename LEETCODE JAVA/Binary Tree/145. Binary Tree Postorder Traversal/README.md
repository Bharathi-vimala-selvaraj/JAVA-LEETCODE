# 🍂 Postorder Traversal

## 🧠 Core Idea

**Postorder = Left → Right → Root**

```text
        1
       / \
      2   3
     / \
    4   5

```

Output:

```text
[4, 5, 2, 3, 1]

```

---

## 🔑 Logic

```text
1. If root == null → STOP
2. Traverse left
3. Traverse right
4. Add root.val

```

### Code Pattern

```java
if (root == null) {
    return;
}

postorder(root.left, a);  // LEFT
postorder(root.right, a); // RIGHT
a.add(root.val);         // ROOT

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
1 → go left to 2
↓
2 → go left to 4
↓
4 → left is null → return
↓
4 → right is null → return
↓
4 → add 4
↓
2 → go right to 5
↓
5 → left is null → return
↓
5 → right is null → return
↓
5 → add 5
↓
2 → add 2
↓
3 → left & right are null → add 3
↓
1 → add 1

```

Result:

```text
[4, 5, 2, 3, 1]

```

---

## 📦 Why `List<Integer>`?

We need a place to store the traversal result.

```java
List<Integer> a = new ArrayList<>();

```

The **same list** is passed through every recursive call.

```java
postorder(root.left, a);
postorder(root.right, a);

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
POSTORDER
   ↓
LEFT → RIGHT → ROOT
   ↓
LEFT → RIGHT → ADD

```

### Interview Shortcut

When asked for postorder:

```java
if (root == null) return;

postorder(root.left, a);
postorder(root.right, a);
a.add(root.val);

```

---

## ⏱ Complexity

* **Time:** `O(n)` — every node is visited once.
* **Space:** `O(h)` recursion stack, where `h` is tree height.
* **Output list:** `O(n)`

---

## 💡 Key Takeaway

> **Postorder means: process child nodes first (left, then right), and visit the root last (used for deleting trees or bottom-up evaluations).**
