package boj_11062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,N,DP[][][],arr[],sum=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			sum=0;
			N=Integer.parseInt(br.readLine());
			DP=new int[N+1][N+1][2];
			arr=new int[N+1];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			System.out.println(solve(0,N-1,0));
		}
		
	}
	static int solve(int i,int j,int idx) // i부터 j까지의 최소, 최대 구하는 메소드 
	{
		if(DP[i][j][idx]>0)return DP[i][j][idx];
		if(i==j)
		{
			if(idx==0)return arr[i];
			else return 0;
		}
		if(idx==0) {
			return DP[i][j][0]=Math.max(solve(i+1,j,1)+arr[i],solve(i,j-1,1)+arr[j]); // 근우차례일 때 가장 큰 점수
		}
		else {
			return  DP[i][j][1]=Math.min(solve(i+1,j,0),solve(i,j-1,0)); // 명우차례일 때 가장 작은 점수
		}
	}
}
