import java.util.Scanner;

public class digit_frq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int f = dig_freq(n,d);
        System.out.println(f);
        sc.close();
    }   
    public static int dig_freq(int n,int d) {
        int cnt = 0;
        
        while(n>0){
            int temp  = n%10;
            n = n/10;
            if(temp == d){
                cnt++;
            }
        }
        return cnt;
    } 
}
