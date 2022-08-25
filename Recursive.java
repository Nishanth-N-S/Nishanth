import java.util.*;

public class Recursive {
    static int[] coins = {1, 2, 5};  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        getCoins(list, coins.length-1, sum);
        for(int e : list) {
        	System.out.println(e);
        }
	}
	
	private static void getCoins(List<Integer> list, int coinIndex, int sum) {
		if(sum==0) {
			return;
		}
		if(sum>=coins[coinIndex]) {
			list.add(coins[coinIndex]);
			getCoins(list, coinIndex, sum-coins[coinIndex]);
		}else {
			getCoins(list, coinIndex-1, sum);
		}
	}

}
