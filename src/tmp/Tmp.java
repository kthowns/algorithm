package tmp;
import java.util.*;

public class Tmp{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 8 <= n, m <= 50
        int m = sc.nextInt();
        String[] board = new String[n];
        
        for(int i=0; i<n; i++){
            board[i] = sc.next();
        }
        
        int minCount = Integer.MAX_VALUE;
        for(int i=0; i<=n-8; i++){
            for(int j=0; j<=m-8; j++){
                minCount = Math.min(
                		minCount,
                		Math.min(calcCount(board, j, i, 'W'), calcCount(board, j, i, 'B'))
                );
            }
        }
        
        System.out.println(minCount);
    }
    
    public static int calcCount(String[] board, int x, int y, char next){
        int count = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(board[y+i].charAt(x+j) != next){
                    count++;
                }
                if(next == 'W'){
                    next = 'B';
                } else{
                    next = 'W';
                }
            }
            if(next == 'W'){
                next = 'B';
            } else{
                next = 'W';
            }
        }
        
        return count;
    }
}

/*
    2 * (m-8) * (n-8)
*/