import java.util.Scanner;
import java.util.Stack;

public class nxt_grtr_elm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> st = new Stack<>();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res[] = new int[n];
        st.push(arr[n-1]);
        res[n-1] = -1;
        for(int i=n-2;i>=0;i--){
            if(!st.isEmpty() && arr[i] < st.peek()){
                res[i] = st.peek();
                
            }else{
                while(!st.isEmpty() && st.peek() < arr[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    res[i] = st.peek();
                }else{
                    res[i] = -1;
                }
               
            }
            st.push(arr[i]);
        }
        for(int i = 0;i<n;i++){
            System.out.println(res[i]);
        }
    }
}
