import java.util.*;
public class Tree 
    {
        public class Node
        {
            Node left;
            Node right;
            int data;
            public Node(int key)
            {
                data = key;
                left = right = null;
                
            }
        }
        Node root;
      
        public void inorder()
        {
            inorderWrapper(root);
        }
        int i =0;
        public void  inorderWrapper(Node node)
        {
            if(node==null)
            return;
            i++;
            inorderWrapper(node.left);
            System.out.println("printing data " + i + node.data);
            inorderWrapper(node.right);
        }
        public  Node create(int key)
        {
            Node n = new Node(key);
            if(root == null)
            root = n;
           
            if(key > root.data)
            root.right = create(root.right , key);
            else if(key<root.data)
            root.left = create(root.left,key);
        
            return n;
        }
        public void verticalview(Node node)
        {

        }
        public static void main(String args[])
        {
            Scanner in =new Scanner(System.in);
            int n = in.nextInt();
            Tree t = new Tree ();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            arr[i]  = in.nextInt();
            for(int j=0;j<n;j++)
            t.createWrapper(arr[j]);
            t.inorder();
        }
    }
