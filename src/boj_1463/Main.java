package boj_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] DP;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N;
		N=Integer.parseInt(br.readLine());
		DP=new int[1000001];
		
		DP[0]=0;
		DP[1]=0;
		DP[2]=1;
		DP[3]=1;

		for(int i=4;i<=N;i++)
		{
			DP[i]=DP[i-1]+1;
			if(i%3==0)
				DP[i]=Math.min(DP[i],DP[i/3]+1);
			if(i%2==0)
				DP[i]=Math.min(DP[i],DP[i/2]+1);
		}
		System.out.println(DP[N]);
	}

}
