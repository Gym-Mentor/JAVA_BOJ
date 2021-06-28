package boj_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean graph[][];
	static int result=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		
		graph=new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int num1=Integer.parseInt(st.nextToken());
			int num2=Integer.parseInt(st.nextToken());
			graph[num1][num2]=true;
			graph[num2][num1]=true;
		}
		
		bfs(N);
		System.out.println(result);
	}
	
	static void bfs(int N)
	{
		Queue<Integer> q = new LinkedList<>();
		boolean check[]=new boolean[N+1];
		q.offer(1);
		check[1]=true;
		
		while(!q.isEmpty())
		{
			int num=q.poll();
			for(int i=1;i<=N;i++)
			{
				if(!check[i]&&graph[num][i])
				{
					check[i]=true;
					q.offer(i);
					result++;
				}
			}
		}
			
		
	}
}
