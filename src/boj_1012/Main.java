package boj_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int T,M,N,K,result;
	static boolean graph[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			graph=new boolean[N][M];
			result=0;
			for(int i=0;i<K;i++)
			{
				st=new StringTokenizer(br.readLine());
				int num1=Integer.parseInt(st.nextToken());
				int num2=Integer.parseInt(st.nextToken());
				
				graph[num2][num1]=true;
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(graph[i][j])
					{
						bfs(i,j);
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
		
	}

	static void bfs(int Y,int X)
	{
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {Y,X});
		graph[Y][X]=false;
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&graph[nextY][nextX])
				{
					graph[nextY][nextX]=false;
					q.offer(new int[] {nextY,nextX});
				}
			}
		}
	}
}
