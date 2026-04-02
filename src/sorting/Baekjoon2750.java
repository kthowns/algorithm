package sorting;

import java.util.*;

public class Baekjoon2750 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> nums = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            nums.add(sc.nextInt());
        }
        
        Collections.sort(nums);
        
        for(int i=0; i<n; i++){
            System.out.println(nums.get(i));
        }
    }
}
