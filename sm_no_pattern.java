import java.util.Scanner;
import java.util.Stack;

public class sm_no_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str  = sc.next();
        sc.close();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'd'){
                st.push(num);
                num++;
            }else{
                st.push(num);
                num++;
                while(st.size() > 0){
                    System.out.print(st.pop());
                }
            }
        }
        st.push(num);
        while(st.size() > 0){
            System.out.print(st.pop());
        }
    }    
}
