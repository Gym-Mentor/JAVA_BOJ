package boj_14889;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,T,min=Integer.MAX_VALUE;
	static int arr[][];
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
			N=Integer.parseInt(br.readLine());
			arr=new int[N][N];
			min=Integer.MAX_VALUE;
			for(int i=0;i<N;i++)
			{
				StringTokenizer st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int visited[]=new int[N/2];
			comb(0,0,visited);
			System.out.println(min);
		
	}
	static void comb(int cnt,int start,int visited[])
	{
		if(cnt==N/2)
		{
			init(visited);
			return;
		}
		for(int i=start;i<N;i++)
		{
			visited[cnt]=i;
			comb(cnt+1,i+1,visited);
		}
	}
	static void init(int visited[]) 
	{

		boolean v[]=new boolean[N];
		for(int i=0;i<N/2;i++)
		{
			v[visited[i]]=true;
		}
		int y=0;
		int n=0;
		for(int i=0;i<N;i++)
		{
			if(v[i])
				for(int j=i+1;j<N;j++)
				{
					if(v[j])
					{
						y+=arr[i][j];
						y+=arr[j][i];
					}
				}
			else
				for(int j=i+1;j<N;j++)
				{
					if(!v[j])
					{
						n+=arr[i][j];
						n+=arr[j][i];
					}
				}
				
		}
		min=Math.min(min, Math.abs(y-n));
	}
}
