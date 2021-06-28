package boj_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,L,R,result=0,cnt=0;
	static boolean visited[][];
	static int board[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		board=new int[N][N];
		visited=new boolean[N][N];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.println(result);
	}
	static void solve()
	{
		while(true)
		{
			cnt=0;
			for(boolean[] rows:visited)
			{
				Arrays.fill(rows, false);
			}
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(!visited[i][j])
					{
						bfs(i,j);
					}
				}
			}
			if(cnt==0)return;
			result++;
		}
	}
	static void bfs(int Y,int X)
	{
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {Y,X});
		visited[Y][X]=true;
		
		int sum=board[Y][X];
		Queue<int[]> list=new LinkedList<>();
		list.offer(new int[] {Y,X});
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX])
				{
					int diff=Math.abs(board[nowY][nowX]-board[nextY][nextX]);
					if(L<=diff&&diff<=R)
					{
						visited[nextY][nextX]=true;
						q.offer(new int[] {nextY,nextX});
						list.offer(new int[] {nextY,nextX});
						sum+=board[nextY][nextX];
					}
				}
			}
		}
		if(list.size()>1)
		{
			cnt++;
		}
		else
		{
			return;
		}
		sum=sum/list.size();
		while(!list.isEmpty())
		{
			board[list.peek()[0]][list.peek()[1]]=sum;
			list.poll();
		}
	}
}
