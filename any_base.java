import java.util.Scanner;

public class any_base {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int res1 = base_to_Decimal(n, b1);
        int res2 = decimal_to_base(res1, b2);
        System.out.println(res2);
        sc.close();
    }
    public static int base_to_Decimal(int n,int b2) {
        int res = 0;
        int p = 1;
        while(n>0){
            int temp = n%10;
            n/=10;
            res+=temp*p;
            p*=b2;
        }
        return res;
    }
    public static int decimal_to_base(int n,int b) {
        int res = 0;
        int p = 1;
        while(n>0){
            int temp = n%b;
            n/=b;
            res+=temp*p;
            p*=10;
        }
        return res;
    }
}
