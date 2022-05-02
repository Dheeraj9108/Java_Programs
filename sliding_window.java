import java.util.*;
public class sliding_window {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(arr.length-1);
        nge[arr.length-1] = arr.length;
        for(int i= arr.length-2;i>=0;i--){
            while(st.size() > 0 && arr[i] >= arr[st.peek()]){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = arr.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        
        for(int i=0;i<arr.length-k;i++){
            int j = i;
            while(nge[j] < i+k){
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }
    
}
