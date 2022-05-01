import java.util.Scanner;
import java.util.Stack;

public class largest_area_histogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]  = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int rb[] = new int[n];
        Stack<Integer> st = new Stack<>();
        rb[arr.length-1] = arr.length;
        st.push(arr.length-1);
        for(int i=arr.length-2;i>=0;i--){
            while(st.size() > 0 && arr[i] < arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                rb[i] = arr.length;
            }else{
                rb[i] = st.peek();
            }
            st.push(i);
        }
        Stack<Integer> stk = new Stack<>();
        int lb[] = new int[n];
        lb[0] = -1;
        stk.push(0);
        for(int i=1;i<n;i++){
            while(stk.size() > 0 && arr[i] < arr[stk.peek()]){
                stk.pop();
            }
            if(stk.size() == 0){
                lb[i] = -1;
            }else{
                lb[i] = stk.peek();
            }
            stk.push(i);
        }

        int max_Area = 0;
        int width = 0;
        for(int i=0;i<n;i++){
            width = rb[i] - lb[i] - 1;
            int area = width * arr[i];
            if(max_Area < area){
                max_Area = area;
            }
        }
        System.out.println(max_Area);
    }
}
