import java.util.Scanner;
import java.util.Stack;

public class duplicate_bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.next();
        sc.close();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ')'){
                if(stk.peek() == '('){
                    System.out.println("false");
                    return;
                }else{
                    while(stk.peek() != '('){
                        stk.pop();
                    }
                    
                    stk.pop();
                }
            }else{
                stk.push(str.charAt(i));
            }
        }
    }
    
}
