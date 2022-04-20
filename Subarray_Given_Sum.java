import java.util.*;



class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
        sc.close();
    }

}// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
     ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int left = 0;
        int right = 0;
        int curr_sum = 0;
        int flag = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            curr_sum+=arr[right];
            right++;
            if(curr_sum == s){
                flag =1;
                break;
            }else if(curr_sum > s){
                while(curr_sum > s){
                    curr_sum-=arr[left];
                    left++;
                    if(curr_sum == s){
                       flag = 1;
                       break;
                    }
                }
                if(flag == 1){
                    break;
                }
            }
        } 
        if(flag == 1){
            res.add(left+1);
            res.add(right);
        }else{
            res.add(-1);
        }
        return res;
    }
}