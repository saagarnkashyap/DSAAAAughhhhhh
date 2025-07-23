import java.util.*;
class treetraversal{
    static class node{//structure of node in a tree 
        int data;
        node left;
        node right;
        node(int n){
            data = n;
            left = null;
            right = null;
        }
    }
    static node built(String s[]){
        if(s.length==0||s[0].equals("-1")) return null;
        node root = new node(Integer.parseInt(s[0]));
        Queue<node> q = new LinkedList<>();
        q.add(root);//1
        int i = 1;//since already root is done 
        while(i<s.length&&!q.isEmpty()){
            node cur = q.poll();//1,2,3,4,5,6,7
            int cval = Integer.parseInt(s[i]);//4,6,-1,7
            if(cval!=-1){
                cur.left = new node(cval);//4,6,7
                q.add(cur.left);//6,7
            }
            i++;//next index element 
            if(i>=s.length) break;//if i/p is completed 
            cval = Integer.parseInt(s[i]);//5,-1,-1
            if(cval!=-1){
                cur.right = new node(cval);//5
                q.add(cur.right);
            }
            i++;//next index element 
        }
        return root;
    }
    static void postorder(node root){ // for postorder
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    static void preorder(node root){ // for preorder
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void inorder(node root){ // for inorder
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
        
    }
    public static void main(String ar[]){
        Scanner sw = new Scanner(System.in);
        String s[] = sw.nextLine().split(" ");
        node root = built(s);
        System.out.println("Inorder Traversal printing");
        inorder(root);
        System.out.println();
        System.out.println("Preorder Traversal printing");
        preorder(root);
        System.out.println();
        System.out.println("Postorder Traversal printing");
        postorder(root);
        System.out.println();
    }
}

