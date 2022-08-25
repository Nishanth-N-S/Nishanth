import java.util.*;
public class Greedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] coins = {1, 2, 5};  
        int index = coins.length-1;
        while(sum>0) {
        	int am = coins[index];
        	int thisCoins = sum/am;
        	for(int i = 0; i<thisCoins; i++) {
        		System.out.println(am);
        	}
        	sum-=thisCoins*am;
        	index--;
        }
	}

}
