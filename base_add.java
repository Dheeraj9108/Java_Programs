import java.util.Scanner;

public class base_add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int res = add(n1,n2,b);
        System.out.println(res);
        sc.close();
    }
    public static int add(int n1,int n2,int b) {
        int res = 0;
        int p = 1;
        int c = 0;
        while(n1>0 || n2>0 || c>0){
            int d1 = n1%10;
            int d2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            
            int d = d1+d2+c;
            c = d / b;
            d = d % b;

            res+=d*p;
            p*=10;
        }
        return res;
    }
}
