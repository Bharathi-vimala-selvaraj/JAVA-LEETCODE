# 🌿 Inorder Traversal

## 🧠 Core Idea

**Inorder = Left → Root → Right**

```text
        1
       / \
      2   3
     / \
    4   5

```

Output:

```text
[4, 2, 5, 1, 3]

```

---

## 🔑 Logic

```text
1. If root == null → STOP
2. Traverse left
3. Add root.val
4. Traverse right

```

### Code Pattern

```java
if (root == null) {
    return;
}

inorder(root.left, a);  // LEFT
a.add(root.val);        // ROOT
inorder(root.right, a); // RIGHT

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
4 → add 4
↓
4 → right is null → return
↓
2 → add 2
↓
2 → go right to 5
↓
5 → add 5
↓
1 → add 1
↓
3 → add 3

```

Result:

```text
[4, 2, 5, 1, 3]

```

---

## 📦 Why `List<Integer>`?

We need a place to store the traversal result.

```java
List<Integer> a = new ArrayList<>();

```

The **same list** is passed through every recursive call.

```java
inorder(root.left, a);
inorder(root.right, a);

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
INORDER
   ↓
LEFT → ROOT → RIGHT
   ↓
LEFT → ADD → RIGHT

```

### Interview Shortcut

When asked for inorder:

```java
if (root == null) return;

inorder(root.left, a);
a.add(root.val);
inorder(root.right, a);

```

> **BST Special Property:** Inorder traversal of a **Binary Search Tree (BST)** always produces elements in **sorted ascending order**.

---

## ⏱ Complexity

* **Time:** `O(n)` — every node is visited once.
* **Space:** `O(h)` recursion stack, where `h` is tree height.
* **Output list:** `O(n)`

---

## 💡 Key Takeaway

> **Inorder means: go left first, visit the node in the middle, then go right.**
