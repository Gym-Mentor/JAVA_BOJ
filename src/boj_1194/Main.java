package boj_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,min=Integer.MAX_VALUE;
	static char board[][];
	static int minsikY,minsikX;
	static boolean[][][] visited;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken()); // 세로
		M=Integer.parseInt(st.nextToken()); // 가로
		board=new char[N][M]; // 미로
		visited=new boolean[1<<6][N][M];
		//입력받기
		for(int i=0;i<N;i++)
		{
			String str=br.readLine();
			for(int j=0;j<M;j++)
			{
				board[i][j]=str.charAt(j);
				
				//민식이 위치 저장
				if(board[i][j]=='0')
				{
					minsikY=i;
					minsikX=j;
				}
			}
		}
		bfs();
	}
	
	// 네 방향 중에 갈 수 있는 곳 찾기
	static void bfs()
	{
		Queue<int []> q=new LinkedList<>();
		q.offer(new int[] {minsikY,minsikX,0,0}); // 현재 Y, 현재 X, 이동횟수, key
		visited[0][minsikY][minsikX]=true;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			int nowSum=q.peek()[2];
			int nowKey=q.peek()[3];
			q.poll();
			
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nowKey][nextY][nextX])
				{
					if(board[nextY][nextX]=='.'||board[nextY][nextX]=='0')
					{
						visited[nowKey][nextY][nextX]=true;
						q.offer(new int[] {nextY,nextX,nowSum+1,nowKey});
					}
					else if('a'<=board[nextY][nextX]&&board[nextY][nextX]<='f')
					{
						visited[nowKey][nextY][nextX]=true;
						q.offer(new int[] {nextY,nextX,nowSum+1,insertKey(nowKey,board[nextY][nextX])});
					}
					else if('A'<=board[nextY][nextX]&&board[nextY][nextX]<='F')
					{
						if(getKey(nowKey,board[nextY][nextX]))
						{
							visited[nowKey][nextY][nextX]=true;
							q.offer(new int[] {nextY,nextX,nowSum+1,nowKey});
						}
					}
					else if(board[nextY][nextX]=='1')
					{
						System.out.println(nowSum+1);
						return;
					}
				}
			}
		}
		System.out.println("-1");
	}
	static int insertKey(int key,char c)
	{
		return key|(1<<(c-'a'));
	}
	static boolean getKey(int key, char c)
	{
		int nowKey=1<<(c-'A');
		if((nowKey&key)==nowKey)return true;
		else return false;
	}
}
