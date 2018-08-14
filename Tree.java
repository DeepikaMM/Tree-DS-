import java.util.*;
import java.util.Map.Entry;
public class Tree {
 Node root;
 public class Node {
  Node left;
  Node right;
  int data;
  public Node(int key) {
   data = key;
   left = right = null;

  }
 }

 public void createWrapper(int key) {
  root = create(root, key);
 }

 public Node create(Node node, int key) {
  Node n = new Node(key);
  if (node == null)
   return n;
  if (key > node.data)
   node.right = create(node.right, key);
  else if (key < node.data)
   node.left = create(node.left, key);
  return node; // return the node not 'n'
 }
 public void VerticalViewWrapper() {
  TreeMap < Integer, Vector < Integer >> treeset = new TreeMap < Integer, Vector < Integer >> ();
  VerticalView(treeset, 0, root);

  for (Entry < Integer, Vector < Integer >> entry: treeset.entrySet()) {
   System.out.println(entry.getValue());
  }
 }
 public void VerticalView(TreeMap < Integer, Vector < Integer >> treeset, int count, Node node) {
  if (node == null)
   return;
  Vector < Integer > list = treeset.get(count);
  if (list != null) {

   list.add(node.data);
   treeset.put(count, list);
  } else {

   list = new Vector < Integer > ();
   list.add(node.data);

   treeset.put(count, list);

  }
  VerticalView(treeset, count + 1, node.right);
  VerticalView(treeset, count - 1, node.left);
 }
 public void inorder() {
  inorderWrapper(root);
 }

 public void inorderWrapper(Node node) {
  if (node == null)
   return;
  inorderWrapper(node.left);
  System.out.println(node.data);
  inorderWrapper(node.right);
 }

 public void horizontalView() {
  Queue < Node > q = new LinkedList < Node > ();
  q.add(root);
  while (q.size() != 0) {
   Node temp = q.peek();
   System.out.println(temp.data);
   if (temp.left != null)
    q.add(temp.left);
   if (temp.right != null)
    q.add(temp.right);
   q.remove();
  }
 }
 public int heightOfTree(Node root) {
     if(root==null)
     return 0;
     else {
         int lheight = heightOfTree(root.left);
         int rheight = heightOfTree(root.right);

         return Math.max(lheight,rheight)+1;
     }
 }
 
 public void leftViewWrapper() {
     int height = heightOfTree(root);
     for(int i=1;i<=height;i++)
     LeftView(root,i);
 }
 public void LeftView(Node root,int level) {
     if(root==null)
     return;
     if(level==1)
     System.out.println(root.data);
     else if(level>1)
     LeftView(root.left,level-1);
 }
 public void DiagonalWrapper()
 {
     TreeMap<Integer,Vector<Integer>> treemap = new TreeMap<Integer,Vector<Integer>>();
     DiagonalView(root,treemap,0);
     for(Map.Entry<Integer,Vector<Integer>> entry: treemap.entrySet())
     {
         System.out.println(entry.getValue());
     }
 }
 public void DiagonalView(Node root,TreeMap<Integer,Vector<Integer>> treemap, int count) {
     if(root==null)
     return;
     Vector<Integer> temp = treemap.get(count);
     if(temp!=null) {
        
        temp.add(root.data);
        treemap.put(count,temp);
     }
     else {
        temp = new Vector<Integer>();
        temp.add(root.data);
        treemap.put(count,temp);
     }
    
    
         DiagonalView(root.right,treemap,count);
         DiagonalView(root.left,treemap,count+1);        
      
 }
 public static void main(String args[]) {
  Scanner in = new Scanner(System.in);
  int n = in .nextInt();
  Tree t = new Tree();

  int arr[] = new int[n];
  for (int i = 0; i < n; i++)
   arr[i] = in .nextInt();
  for (int j = 0; j < n; j++) {
   t.createWrapper(arr[j]);
  }
  System.out.println("\n");
  //t.inorder();
  // t.VerticalViewWrapper();
  //t.horizontalView();
  //t.leftViewWrapper();
  t.DiagonalWrapper();

 }
}