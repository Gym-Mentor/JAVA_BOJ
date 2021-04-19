package boj_2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//키 순서
public class Main {

	static int N,M;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][N+1];
//		Arrays.fill(arr, Integer.MAX_VALUE);
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine());
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			// 나보다 큰 사람과 작은사람 둘다 체크
			arr[from][to]=1; 
			arr[to][from]=-1;
		}
		
		
		
		//플로이드 와샬 알고리즘으로 특정 노드와 자신이 연결되는지 체크
		for(int k=1;k<=N;k++)
		{
			for(int i=1;i<=N;i++)
			{
				if(i==k)continue;
				for(int j=1;j<=N;j++)
				{
					if(j==k||j==i)continue;
					if(arr[i][j]==0)
					{
						if(arr[i][k]==1&&arr[k][j]==1)
							arr[i][j]=1;
						if(arr[i][k]==-1&&arr[k][j]==-1)
							arr[i][j]=-1;
					}
				}
			}
		}
		
		// 몇 명이나 순서를 아는지 체크
		int result=0;
		for(int i=1;i<=N;i++)
		{
			boolean check=false;
			for(int j=1;j<=N;j++)
			{
				if(i!=j&&arr[i][j]==0)
				{
					check=true;
					break;
				}
			}
			if(!check)
			{
				result++;
			}
		}
		System.out.println(result);
	}

}
