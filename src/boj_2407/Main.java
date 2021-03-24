package boj_2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger DP[][]=new BigInteger[101][101];
		
		DP[1][0]=BigInteger.ONE;
		DP[1][1]=BigInteger.ONE;
		
		int N,M;
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		for(int i=2;i<=N;i++)
		{
			for(int j=0;j<=i;j++)
			{
				if(j==0||i==j)
				{
					DP[i][j]=BigInteger.ONE;
				}
				else
				{
					DP[i][j]=DP[i-1][j].add(DP[i-1][j-1]);
				}
			}
		}
		
		System.out.println(DP[N][M]);
	}

}
