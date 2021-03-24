package boj_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,result=-1,M;
	static int start,end;
	static boolean arr[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new boolean[N+1][N+1];
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		start=Integer.parseInt(st.nextToken());
		end=Integer.parseInt(st.nextToken());
		
		M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++)
		{
			st= new StringTokenizer(br.readLine()," ");
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			arr[num2][num1]=true;
			arr[num1][num2]=true;
		}
		dfs(start,0);
		System.out.println(result);
	}
	static void dfs(int n,int cnt)
	{
		
		if(n==end)
		{
			result=cnt;
			return;
		}
		for(int i=1;i<=N;i++)
		{
			if(arr[n][i]||arr[i][n])
			{
				arr[n][i]=false;
				arr[i][n]=false;
				dfs(i,cnt+1);
			}


		}
	}
}
