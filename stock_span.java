import java.util.Scanner;
import java.util.Stack;

public class stock_span {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] res = solve(arr);
        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
    }
    public static int[] solve(int[] arr) {
        int span [] =new int[arr.length];
        span[0] = 1;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                st.pop();
            }
            if(st.size()  == 0){
                span[i] = i+1;
            }else{
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        return span;
    }
}
