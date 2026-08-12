# 102 - Binary Tree Level Order Traversal

## Problem

Given the root of a binary tree, return the nodes of the tree **level by level from left to right**.

Example:

```text
        10
       /  \
     20    30
    / \      \
   40  50     60
```

Output:

```text
[[10], [20, 30], [40, 50, 60]]
```

---

## Approach

```text
Level Order
     ↓
    BFS
     ↓
   Queue
```

Since a queue follows **FIFO (First In, First Out)**, nodes are processed in the required left-to-right level order.

---

## Important Code Snippets

### 1. Create the Queue

```java
Queue<TreeNode> q = new LinkedList<>();
```

### 2. Add Root

```java
q.add(root);
```

### 3. Remove and Process a Node

```java
TreeNode current = q.poll();

a.add(current.val);
```

### 4. Add Children

```java
if (current.left != null)
    q.add(current.left);

if (current.right != null)
    q.add(current.right);
```

---

## ⭐ Key Concept: `q.size()`

The important part of **level-by-level BFS** is:

```java
int size = q.size();

for (int i = 0; i < size; i++) {
    // process current level
}
```

`q.size()` takes a **snapshot** of how many nodes belong to the current level.

### Example

```text
Queue = [20, 30]

size = 2
```

After processing `20`, suppose we add `40` and `50`:

```text
Queue = [30, 40, 50]
size  = 2
```

The `size` remains `2`.

### Memory Trick

```text
QUEUE → LIVE
SIZE  → SNAPSHOT
```

---

## Why `while` + `for`?

```java
while (!q.isEmpty()) {
```

Controls the **levels**.

```java
int size = q.size();
```

Finds the number of nodes in the **current level**.

```java
for (int i = 0; i < size; i++) {
```

Processes exactly those nodes.

### Remember

```text
while → levels
for   → nodes in current level
```

---

## New List for Every Level

The level list must be created **inside** the `while` loop:

```java
while (!q.isEmpty()) {

    List<Integer> a = new ArrayList<>();

    int size = q.size();

    // process current level

    l.add(a);
}
```

This gives:

```text
[10]
[20, 30]
[40, 50, 60]
```

instead of putting every node into the same list.

---

## Empty Tree

Always handle:

```java
if (root == null) {
    return;
}
```

For an empty tree:

```text
[]
```

---

## Common Pitfalls

### 1. Using `q.size()` directly in the loop

Avoid:

```java
for (int i = 0; i < q.size(); i++)
```

The queue changes when children are added.

Use:

```java
int size = q.size();

for (int i = 0; i < size; i++)
```

---

### 2. Forgetting the null check

```java
if (root == null)
    return;
```

Without it, trying to access `current.val` can cause a `NullPointerException`.

---

### 3. Forgetting to add children

```java
if (current.left != null)
    q.add(current.left);

if (current.right != null)
    q.add(current.right);
```

Always remember:

```text
LEFT → RIGHT
```

---

### 4. Confusing `poll()` and `peek()`

```java
q.poll();   // removes the front node
q.peek();   // only looks at the front node
```

For traversal, use:

```java
TreeNode current = q.poll();
```

---

## Normal BFS vs Level-by-Level BFS

### Normal BFS

```text
Queue
 ↓
poll
 ↓
process
 ↓
left
 ↓
right
 ↓
repeat
```

Used when output is simply:

```text
10 20 30 40 50 60
```

### Level-by-Level BFS

```text
Queue
 ↓
q.size()
 ↓
for(size)
 ↓
poll
 ↓
process
 ↓
left
 ↓
right
 ↓
next level
```

Used when output is:

```text
[[10], [20, 30], [40, 50, 60]]
```

---

## Interview Recognition

| If the interviewer says...   | Think...                   |
| ---------------------------- | -------------------------- |
| Level Order                  | BFS + Queue                |
| Breadth First                | Queue                      |
| Level by Level               | Queue + `size`             |
| Each level separately        | Queue + `size`             |
| Return `List<List<Integer>>` | Queue + `size`             |
| Zigzag Level Order           | Queue + `size` + direction |
| Right Side View              | Queue + `size`             |

---

## 🔒 Sleep Revision

```text
LEVEL ORDER
     ↓
    BFS
     ↓
   QUEUE
     ↓
 q.size()
     ↓
 for(size)
     ↓
   poll()
     ↓
 process
     ↓
 LEFT
     ↓
 RIGHT
```

### Golden Rule

> **POLL → PROCESS → LEFT → RIGHT**

### Ultimate Memory Trick

```text
QUEUE = LIVE
SIZE  = SNAPSHOT
```

```text
while → levels
for   → current level
```

---

## Complexity

```text
Time  : O(n)
Space : O(n)
```

Every node is processed exactly once.

---

## Key Takeaways

```text
1. Level Order = BFS
2. BFS = Queue
3. Queue = FIFO
4. Normal BFS does not need q.size()
5. Level-by-level BFS needs q.size()
6. q.size() is a snapshot
7. Create a new ArrayList for every level
8. Process exactly `size` nodes
9. Add left child before right child
10. Handle root == null
```

### One-Line Revision

> **`while` finds the levels, `size` marks the current level, and `for` processes exactly that level.**
