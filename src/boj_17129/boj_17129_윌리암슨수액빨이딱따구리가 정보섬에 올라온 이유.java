package boj_17129;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,Y,X;
	static boolean arr[][];
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static int[][] goal;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		arr=new boolean[N][M];
		goal=new int[3][2];
		
		int cnt=0;
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<M;j++)
			{
				int num=str.charAt(j)-'0';
				if(num==0)
				{
					arr[i][j]=false;
				}
				else if(num==1)
				{
					arr[i][j]=true;
				}
				else if(num==2)
				{
					arr[i][j]=false;
					Y=i;
					X=j;
				}
				else
				{
					arr[i][j]=false;
					goal[cnt][0]=i;
					goal[cnt++][1]=j;
				}
			}
		}
		BFS(Y,X);
	
		
	}
	static void BFS(int y, int x)
	{
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {y,x});
		arr[y][x]=true;
	
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&arr[nextY][nextX]==false)
				{
					for(int j=0;j<3;j++)
					{
						if(nextY==goal[j][0]&&nextX==goal[j][1])
						{
							int result=Math.abs(Y-nextY)+Math.abs(X-nextX);
							System.out.println("TAK");
							System.out.println(result);
							return;
						}
					}
					
					if(arr[nextY][nextX]==false)
					{
						q.offer(new int[] {nextY,nextX});
						arr[nextY][nextX]=false;
					}
					
				}
				
			}
		}
		System.out.println("NIE");
		return;
	}
}
