import java.util.ArrayList;

import java.util.Stack;

public class tree {
    private static class Node{
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }
    public static void main(String[] args) {
        int arr[] = {10,20,50,-1,60,-1,-1};
        Stack<Node> st = new Stack<>();
        Node root;
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
    }
}
