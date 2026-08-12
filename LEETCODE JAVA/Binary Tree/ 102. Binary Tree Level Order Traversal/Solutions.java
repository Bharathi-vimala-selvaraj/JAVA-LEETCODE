/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l=new ArrayList<>();
      levelorder(root,l);
      return l;

    }
void levelorder(TreeNode root , List<List<Integer>> l){
    Queue<TreeNode> q=new LinkedList<>();
   if(root==null){
    return;
   }
    q.add(root);
while (!q.isEmpty()) {
 List<Integer> a=new ArrayList<>();
    int size = q.size();

    for (int i = 0; i < size; i++) {

        TreeNode current = q.poll();

        a.add(current.val);

        if (current.left != null)
            q.add(current.left);

        if (current.right != null)
            q.add(current.right);
    }

  l.add(a);
}
        
    }
}
