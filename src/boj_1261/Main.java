package boj_1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Info implements Comparable<Info>{
		int Y;
		int X;
		int cost;
		public Info(int y, int x, int cost) {
			super();
			Y = y;
			X = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}
	static int distance[][],arr[][];
	static int N,M,result;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static PriorityQueue<Info> pq;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		arr=new int[N+1][M+1];
		distance=new int[N+1][M+1];
		
		for(int i=1;i<=N;i++)
		{
			String str=br.readLine();
			for(int j=1;j<=M;j++)
			{
				arr[i][j]=str.charAt(j-1)-'0';
			}
		}
		for(int i=1;i<=N;i++)
		{
			for(int j=1;j<=M;j++)
			{
				distance[i][j]=100000;
			}
		}
		distance[1][1]=0;
		
		pq=new PriorityQueue<>();
		bfs();
		System.out.println(result);
	}
	static void bfs()
	{
		pq.add(new Info(1,1,0));
		
		while(!pq.isEmpty())
		{
			Info now=pq.poll();
			
			if(now.Y==N&&now.X==M)
			{
				result=now.cost;
				return;
			}
			for(int i=0;i<4;i++)
			{
				int nextY=now.Y+dy[i];
				int nextX=now.X+dx[i];
				
				if(0<nextY&&nextY<=N&&0<nextX&&nextX<=M)
				{
					if(distance[nextY][nextX]>distance[now.Y][now.X]+arr[nextY][nextX])
					{
						distance[nextY][nextX]=distance[now.Y][now.X]+arr[nextY][nextX];
						pq.add(new Info(nextY,nextX,distance[nextY][nextX]));
					}
				}
			}
		}
	}
}
