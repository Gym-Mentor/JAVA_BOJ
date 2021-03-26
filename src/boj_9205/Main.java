package boj_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T,N;
	static int DP[][],dist[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++)
		{
			N=Integer.parseInt(br.readLine());
			DP=new int [N+2][2];
			dist=new int[N+2][N+2];
			for(int i=0;i<N+2;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine()," ");
				int num1=Integer.parseInt(st.nextToken());
				int num2=Integer.parseInt(st.nextToken());
				DP[i][0]=num1;
				DP[i][1]=num2;
			}
			for(int i=0;i<N+2;i++)
			{
				for(int j=0;j<N+2;j++)
				{
					if(i!=j)
					dist[i][j]=102;
				}
			}
			for(int i=0;i<N+2;i++)
			{
				for(int j=0;j<N+2;j++)
				{
					if(i==j)continue;
					if(manhattanDistance(i,j)<=1000)
						dist[i][j]=1;
				}
			}
			
			for(int k=0;k<N+2;k++)
			{
				for(int i=0;i<N+2;i++)
				{
					if(i==k)continue;
					for(int j=0;j<N+2;j++)
					{
						if(i==j&&j==k)continue;
						dist[i][j]=Math.min(dist[i][k]+dist[k][j], dist[i][j]);
					}
				}
			}
			
			if(0<dist[0][N+1]&&dist[0][N+1]<102)
			{
				System.out.println("happy");
			}
			else
			{
				System.out.println("sad");
			}
		}
	}
	static int manhattanDistance(int i,int j)
	{
		int distance=Math.abs(DP[i][0]-DP[j][0])+Math.abs(DP[i][1]-DP[j][1]);
		return distance;
	}
}
