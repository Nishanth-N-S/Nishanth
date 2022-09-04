import java.util.*;
public class Queens {
	private static int n;
	private static boolean arr[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("No of queens :");
		n = sc.nextInt();
		System.out.println("----------------------------------");
		
		arr = new boolean[n][n];
		
		if(!place(0)) {
			System.out.println("No solution");
			return;
		}
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(arr[i][j]) {
					System.out.print("Q ");
				}else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	
	private static boolean place(int c) {
		if(c>=n) {
			return true;
		}
		for(int i = 0; i<n; i++) {
			if(isSafe(i, c)) {
				arr[i][c] = true;
				boolean recursive = place(c+1);
				if(recursive) {
					return true;
				}else {
					arr[i][c] = false;
				}
			}
		}
		
		return false;
	}
	
	private static boolean isSafe(int row, int col) {
		for(int i = row-1; i>=0; i--) {
			if(arr[i][col] == true) {
				return false;
			}
		}
		
		for(int i = col-1; i>=0; i--) {
			if(arr[row][i] == true) {
				return false;
			}
		}
		
		for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
			if(arr[i][j] == true) {
				return false;
			}
		}
		
		for(int i = row+1, j = col+1; i<n && j<n; i++, j++) {
			if(arr[i][j] == true) {
				return false;
			}
		}
		
		for(int i = row+1, j = col-1; i<n && j>=0; i++, j--) {
			if(arr[i][j] == true) {
				return false;
			}
		}
		
		for(int i = row-1, j = col+1; i>=0 && j<n; i--, j++) {
			if(arr[i][j] == true) {
				return false;
			}
		}
		
		return true;
	}

}
