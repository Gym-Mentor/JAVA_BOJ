package boj_17836;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,T,result=Integer.MAX_VALUE;
	static int arr[][];
	static boolean visited[][];
	static int dy[]= {0,0,1,-1};
	static int dx[]= {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		visited=new boolean[N][M];
		
		//입력받기
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		// 출력하기
		if(result>T)
		{
			System.out.println("Fail");
		}
		else
		{
			System.out.println(result);
		}
	}

	static void bfs()
	{
		Queue<int[]> q=new LinkedList<>();
		
		q.offer(new int[]{0,0,0});
		visited[0][0]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int dist=q.peek()[2];
			q.poll();
			
			// 검을 찾았을 때
			if(arr[nowY][nowX]==2)
			{
				result=Math.abs(N-1-nowY)+Math.abs(M-1-nowX);
				result+=dist;
			}
			
			//목적지에 도착하면 종료
			if(nowY==N-1&&nowX==M-1)
			{
				if(result>dist)
				{
					result=dist;
					return;
				}
			}
			// 4방위 탐색
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nextY][nextX]&&arr[nextY][nextX]!=1)
				{
					q.offer(new int[] {nextY,nextX,dist+1});
					visited[nextY][nextX]=true;
				}
			}
		}
	}
}
