import java.util.*;
public class Tree 
    {
        public class Node
        {
            Node left;
            Node right;
            public Node(int key)
            {
                data = key;
                left = right = null;
                
            }
        }
        Node root;
        public void createWrapper(int key)
        {
            root = create(root,key);
        }
        public static void inorder()
        {
            inorderWrapper(root);
        }
        public void inorderWrapper(Node root)
        {
            if(node==null)
            return;
            inorderWrapper(root.left);
            System.out.println(root.data);
            inorderWrapper(root.right);
        }
        public static Node create(Node node, int key)
        {
        
            if(node == null)
            {
                Node n = new Node(key);
            return root;
            }
            if(key > node.data)
            node.right = create(node.right , key);
            else if(key<node.data)
            node.left = create(node.left,key);
            else
            return root;
        }
        public static void main(String args[])
        {
            Scanner in =new Scanner(System.in);
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            arr[i]  = in.nextInt();
            for(int j=0;j<n;j++);
            createWrapper(arr[j]);
            inorder();
        }
    }
}