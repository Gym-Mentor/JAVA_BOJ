package boj_4963;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w,h,result=0,arr[][];
	static boolean visited[][];
	static int dy[]= {-1,-1,-1,0,0,1,1,1};
	static int dx[]= {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb= new StringBuilder();
		
		do {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			if(w==0&&h==0)break;
			arr=new int[h][w];
			visited=new boolean[h][w];
			result=0;
			
			for(int i=0;i<h;i++)
			{
				st=new StringTokenizer(br.readLine()," ");
				for(int j=0;j<w;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++)
			{
				for(int j=0;j<w;j++)
				{
					if(!visited[i][j])
					{
						if(arr[i][j]==1)
						{
							result++;
							BFS(i,j);
						}
					}
				}
			}
			
			System.out.println(result);
		}while(true);
	}
	static void BFS(int Y, int X)
	{
		Queue<pair> q= new LinkedList<>();
		visited[Y][X]=true;
		q.offer(new pair(Y,X));
		
		while(!q.isEmpty())
		{
			int nowY=q.peek().first;
			int nowX=q.peek().second;
			q.poll();
			
			for(int i=0;i<8;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<h&&0<=nextX&&nextX<w)
				{
					if(arr[nextY][nextX]==1&&!visited[nextY][nextX])
					{
						visited[nextY][nextX]=true;
						q.offer(new pair(nextY,nextX));
					}
				}
			}
		}
	}
	
	static class pair
	{
		int first;
		int second;
		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
	}
}
