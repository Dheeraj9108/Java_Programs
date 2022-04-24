import java.util.Scanner;
public class base_decimal {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int res = base(n,b);
        System.out.println(res);
        sc.close();
    }
    public static int base(int n,int b) {
        int res = 0;
        int p = 1;
        while(n>0){
            int temp = n%b;
            n/=b;
            res+=temp*p;
            p*=8;
        }
        return res;
    }
}
  