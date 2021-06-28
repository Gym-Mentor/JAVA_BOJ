package boj_1244;

import java.util.Scanner;

public class Main {

	static int S, N;
	

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		S = sc.nextInt();
		int[] arr = new int[S + 1];
		for (int i = 1; i <= S; i++) {
			arr[i] = sc.nextInt();
		}
		N = sc.nextInt();
		while (N-- > 0) // N만큼 반복
		{
			int gender = sc.nextInt();
			int idx = sc.nextInt();

			if (gender == 1) //남자일 경우
			{
				int temp=2,temp2=idx;
				while(idx<=S)
				{
					arr[idx]=arr[idx]==0?1:0;
					idx=temp2*temp++;
				}
			}
			else if(gender==2)
			{
				arr[idx]=arr[idx]==0?1:0;
				int cnt=1;
				while(0<idx-cnt&&idx+cnt<=S)
				{
					if(arr[idx-cnt]!=arr[idx+cnt])
						break;
					else
					{
						arr[idx-cnt]=arr[idx-cnt]==0?1:0;
						arr[idx+cnt]=arr[idx+cnt]==0?1:0;
						cnt++;
					}
				}
			}

		}
		for(int i=1;i<=S;i++)
		{
			System.out.print(arr[i]+" ");
			if(i%20==0)System.out.println();
		}
	}

}
