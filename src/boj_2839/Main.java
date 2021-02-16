package boj_2839;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N;
	static int DP[];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb= new StringBuilder();
		
		N=Integer.parseInt(br.readLine());
		DP=new int[N+1];

		for(int i=0;i<=N;i++)
		{
			DP[i]=9999;
		}
		DP[3]=1;
		if(N>=5)
		DP[5]=1;
		
		for(int i=6;i<=N;i++)
		{
			DP[i]=Math.min(DP[i-3],DP[i-5])+1;
				
		}
		sb.append(DP[N]>=9999?"-1":DP[N]);
		bw.write(sb.toString());
		
		bw.close();
		br.close();
	}
}
