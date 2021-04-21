package boj_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static boolean visited[][];
	static char board[][];
	static int jY,jX;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static Queue<int[]> q=new LinkedList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		visited=new boolean[N][M];
		board=new char[N][M];
		for(int i=0;i<N;i++)
		{
			String str= br.readLine();
			for(int j=0;j<M;j++)
			{
				board[i][j]=str.charAt(j);
				if(board[i][j]=='F')
				{
					q.offer(new int[] {i,j,0,0});
				}
				else if(board[i][j]=='J')
				{
					jY=i;
					jX=j;
				}
			}
		}
		
		bfs();
	}
	static void bfs()
	{
		if(jY==0||jY==N-1|jX==0||jX==M-1)
		{		System.out.println("1");
			return;
		}
		q.offer(new int[] {jY,jX,1,1}); //Y,X,sum,지훈인지아닌지체크
		visited[jY][jX]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int sum=q.peek()[2];
			int check=q.peek()[3];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nextY][nextX])
				{
					
					if(check==0) // 불일 때
					{
						if(board[nextY][nextX]=='.'||board[nextY][nextX]=='J')
						{
							board[nextY][nextX]='F';
							q.offer(new int[] {nextY,nextX,0,0});
						}
					}
					else
					{
						if(board[nextY][nextX]=='.'||board[nextY][nextX]=='J')
						{
							if((nextY==0||nextX==0||nextY==N-1||nextX==M-1)) {
								System.out.println(sum+1);
								return;
							}
							visited[nextY][nextX]=true;
							q.offer(new int[] {nextY,nextX,sum+1,1});
						}
					}
				}
			}
			
		}
		System.out.println("IMPOSSIBLE");
	}
}
