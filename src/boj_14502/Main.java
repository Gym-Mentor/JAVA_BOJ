package boj_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N,M,max=0,size=0,map[][],virus[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		
		// 선언 및 생성
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		virus=new int[10][2];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				map[i][j]=Integer.parseInt(st.nextToken());
				
				// 바이러스 위치 저장
				if(map[i][j]==2)
				{
					virus[size][0]=i;
					virus[size++][1]=j;
				}
			}
		}
		
		//모든 경우의 수 완전 탐색
		comb(0,0,map);
		System.out.println(max);
	}
	
	static void comb(int cnt, int start, int[][] map)
	{
		//벽을 3개 세웠을 때
		if(cnt==3)
		{
			int arr[][]=new int[N][M];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					arr[i][j]=map[i][j];
				}
			}
			int temp=0;
			//바이러스 퍼트리기
			for(int i=0;i<size;i++)
			{
				bfs(virus[i][0],virus[i][1],arr);
			}
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					if(arr[i][j]==0)
					{
						temp++;
					}
				}
			}
			if(max<temp)
			{
				max=temp;
			}
			return;
		}
		
		for(int i=start;i<N*M;i++)
		{
			if(map[i/M][i%M]==0)
			{
				map[i/M][i%M]=1;
				comb(cnt+1,i+1,map);
				map[i/M][i%M]=0;
			}
		}
		
	}
	
	static void bfs(int Y, int X,int arr[][])
	{
		boolean visited[][]=new boolean[N][M];
		Queue<int []> q = new LinkedList<>();
		q.offer(new int[] {Y,X});
		visited[Y][X]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nextY][nextX])
				{
					if(arr[nextY][nextX]==0)
					{
						visited[nextY][nextX]=true;
						arr[nextY][nextX]=2;
						q.offer(new int[]{nextY,nextX});
					}
				}
			}
		}
		
	}
}