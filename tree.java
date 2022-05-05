import java.util.ArrayList;

import java.util.Stack;

public class tree {
    private static class Node{
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }
    //display func
    public static void display(Node node) {
        String str = node.data+"->";
        for(Node child:node.child){
            str+=child.data+",";
        }
        System.out.println(str);
        for(Node child:node.child){
            display(child);
        }
    }
    //size func 
    public static int size(Node node) {
        int s = 0;
        for(Node child:node.child){
            int cs = size(child);
            s+=cs;
        }
        s+=1;
        return s;
    }
    public static int max(Node node) {
        int max = 0;
        int cmax = 0;
        for(Node child:node.child){
            cmax = max(child);
            max = Math.max(cmax, max);
        }
        max = Math.max(node.data,max);
        return max;
    }
    public static void main(String[] args) {
        int arr[] = {10,20,50,-1,60,-1,-1,30};
        Stack<Node> st = new Stack<>();
        Node root =null;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == -1){
                st.pop();
            }else{
                Node t = new Node();
                t.data = arr[i];
                if(st.size() > 0){
                    st.peek().child.add(t);
                }else{
                    root = t;
                }
                st.push(t);
            }
        }
        display(root);
        System.out.println(size(root));
        System.out.println(max(root));
        
    }
}
