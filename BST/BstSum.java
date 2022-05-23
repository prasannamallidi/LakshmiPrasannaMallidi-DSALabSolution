import java.util.*;

public class BstSum 
{
    //BST node
    static class Node 
    {
        int key;
        Node left, right;
    };
    // creation of new node
    static Node newNode(int data) 
    {
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }
    static Node insert(Node root, int key) 
    {
        Node newnode = newNode(key);
        Node x = root;
        Node current_parent = null;
        while (x != null) 
        {
            current_parent = x;
            if (key < x.key)
                x = x.left;
            else if (key > x.key)
                x = x.right;
            else 
            {
                System.out.println("Value already exists!!!");
                return newnode;
            }
        }// If the root is null, the tree is empty.
        if (current_parent == null)
            current_parent = newnode;// assign new node node to the left childelse 
        else if (key < current_parent.key)
            current_parent.left = newnode;// assign the new node to the right child
        else
            current_parent.right = newnode;
        return current_parent;
    }
    
    static void findPairOfSum(Node root, int sum)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        if(!findPair(root, sum, set))
            System.out.println("Nodes are not found");
    }
    static Boolean findPair(Node root, int sum, HashSet<Integer> set)
    {
        if(root == null)
            return false;
        if(findPair(root.left, sum, set))
            return true;
        if(set.contains(sum - root.key))
        {
            System.out.println("Sum = " + sum);
            System.out.println("Pair is (" + (sum - root.key) + "," + root.key + ")");
            return true;
            //set.add(root.key);
        }
        else
            set.add(root.key);
        return findPair(root.right, sum, set);
    }
    public static void main(String args[]) 
    {
            //Scanner sc = new Scanner(System.in);
            int value;
            boolean status;
            Node root = null;
            int[] tree = { 40, 20, 60, 10, 30, 50, 70 };
            for (int i = 0; i < tree.length; i++) 
            {
                value = tree[i];
                if (root == null) 
                {
                    root = insert(root, value);
                } 
                else 
                {
                    insert(root, value);
                }
            }
            findPairOfSum(root, 130);
            
        }
    }
