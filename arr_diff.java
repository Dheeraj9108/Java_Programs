import java.util.Scanner;

public class arr_diff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int arr1[] = new  int[n1];
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int arr2[]  = new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        int diff[] = new int[n2];
        int c = 0;

        int i = n1-1;
        int j = n2-1;
        int k = diff.length-1;

        while(k>=0){
            int d = 0;
            int val = i >= 0?arr1[i]:0;

            if(arr2[j]+c >= val){
                d = arr2[j]+c - val;
                c = 0;
            }else{
                d = arr2[j]+c+10 - val;
                c =-1;
            }
            diff[k] = d;
            i--;
            j--;
            k--;

        }
        int idx = 0;

        while(idx < diff.length){
            if(diff[idx] == 0){
                idx++;
            }else{
                break;
            }
        }
        while(idx < diff.length){
            System.out.print(diff[idx]);
            idx++;
        }


        sc.close();
    }
}
