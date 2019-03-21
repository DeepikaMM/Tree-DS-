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

     if(root.left==null && root.right==null)

     return 1;

     else {

        // int lheight = heightOfTree(root.left);

        // int rheight = heightOfTree(root.right);



         return Math.max(heightOfTree(root.left),heightOfTree(root.right))+1;

     }

 }

 

/* public void leftViewWrapper() {

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

 }*/

 public void leftView() {

     left(root,1);

 }

 static int max =0;

 public void left(Node root, int level) {

    

     if (root == null) 

     return ;

     if(max < level)  {

     System.out.println(root.data);

     max = level;

     }

     left(root.left,level+1);

     left(root.right,level+1);



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

 public void Leaves() {

     leaf(root);

 }

 public void leaf(Node root)

 {

     // as soon as it sees return it will go to next statement

     if(root==null)

     return;

     if(root.left==null && root.right==null)

     System.out.println(root.data);

     leaf(root.left);

     leaf(root.right);

 }

 public void GetleftBoundary() {

     GetLeft(root);

 }

 public void GetLeft(Node root) {

     if(root == null)

     return;

     

     if(root.left!=null || root.right!=null ) {

        System.out.println(root.data);

     }

     

     GetLeft(root.left);

     if(root.left==null) {

     

     GetLeft(root.right);

     }

    

 }

 public void GetrightBoundary() {

     rightBoundary(root);

 }

 public void rightBoundary(Node root) {

     if(root == null)

     return;

     if(root.right!= null || root.left!=null) 

         System.out.println(root.data);

    rightBoundary(root.right);

    if(root.right==null)

    rightBoundary(root.left);

     

 }

 public void dfsWrapper() {

     DFS(root);

 }

 public void DFS(Node root) {

      if(root==null)

      return;

      DFS(root.left);

      System.out.println(root.data);

      DFS(root.right);

 }

 public void inorderwithoutRecursion()

 {

     if(root==null)

     return;

     Stack<Node> stack = new Stack<Node>();

     Node cur = root;

     while(!stack.empty() || cur!=null)

    {

     while(cur!=null )

     {

         stack.push(cur);

         cur=cur.left;

     }

     cur = stack.pop();

     System.out.println(cur.data);

     cur = cur.right;

    }

 }
 public void ConstructTreeFromPreOrderWrapper(int key)
 {
     root = ConstructTreeFromPreOrder(root,key);
 }
 public Node ConstructTreeFromPreOrder(Node node, int key)
 {
      Node n = new Node(key);

  if (node == null)

   return n;

  if (key > node.data)

   node.right = ConstructTreeFromPreOrder(node.right, key);

  else if (key < node.data)

   node.left = ConstructTreeFromPreOrder(node.left, key);

  return node;
     
 }
 public void BTtoBST()
 {
     //calling inorder traversal of a tree
     TreeSet<Integer> set = new TreeSet<Integer>();
     if(root==null)

     return;

     Stack<Node> stack = new Stack<Node>();

     Node cur = root;

     while(!stack.empty() || cur!=null)

    {

     while(cur!=null )

     {

         stack.push(cur);

         cur=cur.left;

     }

     cur = stack.pop();
     
     //System.out.println(cur.data);
     set.add(cur.data);

     cur = cur.right;

    }
    
    Iterator<Integer> it = set.iterator();
    ConstructBst(root,it);
    
 }
 public void ConstructBst(Node root, Iterator<Integer> it)
 {
     if(root==null)
     return ;
     ConstructBst(root.left,it);
     root.data = it.next();
     ConstructBst(root.right,it);
 }
 public  void DeleteNode(int key)
 {
     root = DeleteNodeWrapper(root, key);
 }
 public Node DeleteNodeWrapper(Node root, int key)
 {
     if(root == null)
     return root;
     if(root.data > key)
     root.left = DeleteNodeWrapper(root.left, key);
     else if(root.data<key)
     root.right = DeleteNodeWrapper(root.right, key);
     else
     {
         if(root.left == null)
         return root.right;
         else if(root.right == null)
         return root.left;
         root.data = minValue(root.right);
         root.right = DeleteNodeWrapper(root.right, root.data);
         
     }
     return root;
     
 }
 public int minValue(Node root)
 {
     int minv = root.data;
     while(root.left!= null)
     {
         minv = root.left.data;
         root = root.left;
     }
     return minv;
 }
 public int Sum_All(Node root){
     
     if(root == null)
        return 0;
     return root.data + Sum_All(root.left)+ Sum_All(root.right);
 }
 public void Replace_With_Sum_Of_Greater_nodes(){
     int total = Sum_All(root);
     Replace_All(root,total);
 }
 public void Replace_All(Node root, int total){
     
     if(root == null)
        return;
     
     int leftSum = Sum_All(root.left);
     root.data = total-root.data-leftSum;
     
     Replace_All(root.left,total);
     Replace_All(root.right,total);
 }
 public void DistanceBetween2NodesWrapper(int a, int b){
     System.out.println(DistanceBetween2Nodes(root,a,b));
 }
 public int DistanceBetween2Nodes(Node root, int a, int b){
     if(root == null)
        return 0;
    if(root.data > a && root.data >  b)
        return DistanceBetween2Nodes(root.left,a,b);
    if(root.data <a && root.data <b)
        return DistanceBetween2Nodes(root.right,a,b);
    if((root.data < a && root.data>b ) )
        return  DistanceFromRoot(root.left,a) + DistanceFromRoot(root.right,b);
    return 0;
 }
public int DistanceFromRoot(Node root,int x){
    
    if(root.data == x)
       return 0;
    else if(root.data>x)
        return 1+ DistanceFromRoot(root.left,x);
   
        return 1+DistanceFromRoot(root.right,x);
    
    
}

public  void BSTfromPreOrder(int [] pre){
    Stack<Node> s= new Stack<Node>();
    Node root = new Node(pre[0]);
    s.push(root);
    
    for(int h=1;h<pre.length;h++){
        Node temp = null;
        while(!s.isEmpty() && pre[h]>s.peek().data){
            temp = s.pop();
        }
        if(temp!=null){
            temp.right =new Node(pre[h]);
            s.push(temp.right);
        }
        else{
            temp = s.peek();
            temp.left =new Node(pre[h]);
            s.push(temp.left);
        }
    }
    
    inorderTest(root);
}
public  void inorderTest(Node node) {

  if (node == null)

   return;

  inorderTest(node.left);

  System.out.println(node.data);

  inorderTest(node.right);

 }

 public static void main(String args[]) {

  Scanner in = new Scanner(System.in);

  int n = in .nextInt();

  Tree t = new Tree();



  int arr[] = new int[n];

  for (int i = 0; i < n; i++)

   arr[i] = in .nextInt();

  for (int j = 0; j < n; j++) {

   //t.ConstructTreeFromPreOrderWrapper(arr[j]);
   t.createWrapper(arr[j]);

  }

 

  //t.inorder();

  // t.VerticalViewWrapper();

  //t.horizontalView();

  //t.leftViewWrapper();

  //t.DiagonalWrapper();

  //t.Leaves();

  //t.GetleftBoundary();

  //t.GetrightBoundary();

  //t.dfsWrapper();

  //t.leftView();

  //t.inorderwithoutRecursion();
  //t.BTtoBST();
  //t.inorder();
  //t.DeleteNode(9);
 // t.Replace_With_Sum_Of_Greater_nodes();
 //t.DistanceBetween2NodesWrapper(50,20);
  //t.inorder();
t.BSTfromPreOrder(arr);
 }

}
