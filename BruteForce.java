import java.util.*;
public class BruteForce {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] coins = {1, 3, 4, 5};    
        parent:for(int i = 1;i<=sum; i++) {
        	int[] combination = new int[i];
        	do {
        		int ans = 0;
        		for(int j = 0; j<combination.length; j++) {
        			ans+=coins[combination[j]];
        		}
        		if(ans == sum) {
        			for(int j = 0; j<combination.length; j++) {
        				System.out.println(coins[combination[j]]);
        			}
        			break parent;
        		}
        	}while((combination = nextCombination(combination, coins.length-1))!=null);
        }
	}
	
	
	private static int[] nextCombination(int[] arr, int lenM) {
		boolean reachedEnd = true;
		for(int e : arr) {
			if(e!=lenM) {
				reachedEnd = false;
				break;
			}
		}
		if(reachedEnd) {
			return null;
		}
		for(int i = arr.length-1; i>=0; i--) {
			if(arr[i]==lenM) {
				continue;
			}else if(arr[i]==0) {
				arr[i]=1;
				for(int j = i+1; j<arr.length; j++) {
					arr[j] = 0;
				}
			}else {
				arr[i]++;
			}
			break;
		}
		return arr;
	}
}
