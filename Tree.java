import java.util.*;
import java.util.Map.Entry;
public class Tree 
    {
        Node root;
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

        public void createWrapper(int key)
        {
            root = create(root,key);
        }

        public Node create(Node node, int key)
        {
            Node n = new Node(key);
            if(node == null)
                return n;
            if(key > node.data)
                node.right = create(node.right , key);
            else if(key < node.data)
                node.left = create(node.left,key);
            return node; // return the node not 'n'
        }
          public void VerticalViewWrapper()
        {
             TreeMap<Integer, Vector<Integer>> treeset = new TreeMap<Integer,Vector<Integer>>();
            VerticalView(treeset,0,root);
             
            for (Entry<Integer, Vector<Integer>> entry : treeset.entrySet())
        {
            System.out.println(entry.getValue());
        }
        }
        public void VerticalView(TreeMap<Integer,Vector<Integer>> treeset,int count,Node node)
        {
            if(node==null)
            return;
            Vector<Integer> list = treeset.get(count);
            if(list!=null)
            {
               
                list.add(node.data);
                treeset.put(count,list);
            }
            else
            { 
                 
                 list = new Vector<Integer>();
                list.add(node.data);
              
                treeset.put(count,list);
                 
            }
            VerticalView(treeset,count+1,node.right);
            VerticalView(treeset,count-1,node.left);
        }
        public void inorder()
        {
            inorderWrapper(root);
        }

        public void  inorderWrapper(Node node)
        {
            if(node==null)
                return;
            inorderWrapper(node.left);
            System.out.println(node.data);
            inorderWrapper(node.right);
        }
      

        public static void main(String args[])
        {
            Scanner in =new Scanner(System.in);
            int n = in.nextInt();
            Tree t = new Tree ();
           
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
                arr[i]  = in.nextInt();
            for(int j=0;j<n;j++){
                t.createWrapper(arr[j]);
            }
            System.out.println("\n");
            //t.inorder();
            t.VerticalViewWrapper();
           
        }
    }

