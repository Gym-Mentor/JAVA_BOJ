package boj_2578;

import java.util.Scanner;

public class Main {
	static int result = 1;
	static int[][] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		arr = new int[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int num = sc.nextInt();
				find(num);
				if(check()>=3)
				{	System.out.println(result);
					return;
				}
				result++;
			}
		}
	}

	static void find(int num) {
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (arr[row][col] == num) {
					arr[row][col]=0;
				}
			}
		}
	}

	static int check() {	
		int cnt=0;
		int lcross=0;
		int rcross=0;
		for(int i=0;i<5;i++)
		{
			int row=0;
			int col=0;
			
			for(int j=0;j<5;j++)
			{
				if(arr[i][j]==0)col++;
				if(arr[j][i]==0)row++;
			}
			if(arr[i][i]==0)lcross++;
			if(arr[i][4-i]==0)rcross++;
			if(col==5)cnt++;
			if(row==5)cnt++;
		}
		if(lcross==5)cnt++;
		if(rcross==5)cnt++;
		
		return cnt;
	}
}
