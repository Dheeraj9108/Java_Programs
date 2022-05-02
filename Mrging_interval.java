import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Mrging_interval {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     int arr[][] = new int[n][2];
     for(int i=0;i<n;i++){
         arr[i][0] = sc.nextInt();
         arr[i][1] = sc.nextInt();
     } 
     sc.close();  

     Pair[] pair = new Pair[n];
     for(int i=0;i<n;i++){
        pair[i] = new Pair(arr[i][0],arr[i][1]);
     }
     Arrays.sort(pair);
     Stack<Pair> st = new Stack<>();
     st.push(pair[0]);
     for(int i = 0;i<n;i++){
        if(pair[i].st > st.peek().et){
            st.push(pair[i]);
        }else{
            st.peek().et = Math.max(st.peek().et,pair[i].et);
        }
     }
     Stack<Pair> rs = new Stack<>();
     while(st.size() > 0 ){
         rs.push(st.pop());
     }
     while(rs.size() > 0){
         Pair ele = rs.pop();
         System.out.println(ele.st +" "+ele.et);
     }
     
    } 
    
    public static class Pair implements Comparable<Pair> {
        int st = 0;
        int et = 0;
        Pair(int st,int et){
            this.st = st;
            this.et = et;
        }
        public int compareTo(Pair Other){
            if(this.st != Other.st){
                return this.st - Other.st;
            }else{
                return this.et - Other.et;
            }
        }
    }
}
