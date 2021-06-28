package boj_21609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N,M,result=0;
	static int board[][];
	static boolean visited[][];
	static int blockCnt;
	static int rainbow;
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	static int standardY;
	static int standardX;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		visited=new boolean[N][N];
		board=new int[N][N];
		
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
		// 블록의 크기가 1이상일 때 반복
		while(breakBlock()>1)
		{
			// 블록그룹을 제거
			delete(board[standardY][standardX]);
			// 중력작용
			gravity();
			// 90도 반시계 방향으로 회전
			rotate();
			// 중력작용
			gravity();
		}
	}
	// 반시계 방향으로 90도 회전
	static void rotate()
	{
		int temp[][]=new int[N][N];
		
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				temp[N-1-j][i]=board[i][j];
			}
		}

		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				board[i][j]=temp[i][j];
			}
		}
		
	}
	
	// 중력적용
	static void gravity()
	{
		Stack<Integer> s= new Stack<>();
		
		//열 반복
		for(int j=0;j<N;j++)
		{
			int idx=0;
			while(idx<=N-1)
			{
				if(board[idx][j]==-1) // -1을 만나면 그 위로 스택을 pop
				{
					int cnt=1;
					while(!s.isEmpty())
					{
						board[idx-cnt][j]=s.pop();
						cnt++;
					}
				}
				else if(board[idx][j]>=0) // 0이상일 떄 스택에 저장
				{
					s.push(board[idx][j]);
					board[idx][j]=-2;
				}
				idx++;
			}
			
			while(!s.isEmpty()) // 모든 블록 pop
			{
				board[--idx][j]=s.pop();
			}
		}
		
	}
	
	// 색깔이 같은 블록그룹을 제거 (board[Y][X]값을 -2로 바꿔줌)
	static void delete(int color)
	{
		for(boolean[] rows: visited)
		{
			Arrays.fill(rows, false);
		}
		
		Queue<int[]> q =new LinkedList<>();
		q.offer(new int[] {standardY,standardX});
		visited[standardY][standardX]=true;
		board[standardY][standardX]=-2;
		
		while(!q.isEmpty())
		{
			int nowY=q.peek()[0];
			int nowX=q.peek()[1];
			q.poll();
			for(int i=0;i<4;i++)
			{
				int nextY=nowY+dy[i];
				int nextX=nowX+dx[i];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX]&&(board[nextY][nextX]==0||board[nextY][nextX]==color))
				{
					visited[nextY][nextX]=true;
					q.offer(new int[] {nextY,nextX});
					board[nextY][nextX]=-2;
				}
			}
		}
		
	}
	
	static void print()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j]<0)
				System.out.print(board[i][j]+" ");
				else
					System.out.print(" "+board[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	//가장 큰 블럭을 찾아서 없애는 메서드
	static int breakBlock()
	{
		blockCnt=0;
		rainbow=0;
		standardY=-1;
		standardX=-1;
		//방문 배열 초기화
		for(boolean[] rows: visited)
		{
			Arrays.fill(rows, false);
		}
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(!visited[i][j]&&board[i][j]>=1)
				{
					// 블럭을 찾는 메서드
					bfs(i,j,board[i][j]);
				}
			}
		}
		
		// 일반블록이 1개 이상이고 블록의 수가 2이상일 때
		if(blockCnt>1)
			result+=blockCnt*blockCnt;
			
		return blockCnt;
	}
	
	// (Y,X)좌표의 블럭의 크기를 찾는 메서드
	static void bfs(int Y, int X,int color)
	{
		//현재 블럭의 개수
		int nowBlock=1;
		//현재 무지개 블록 개수
		int nowRainbow=0;
		
		Queue<int[]> q =new LinkedList<>();
		Queue<int[]> rainbowQ=new LinkedList<>();
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
				
				// 아직 방문하지 않았고, 무지개 색이거나 기준 블록과 색이 같은 블록을 방문
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX]&&(board[nextY][nextX]==0||board[nextY][nextX]==color))
				{
					nowBlock++;
					if(board[nextY][nextX]==0)
					{
						nowRainbow++;
						// 무지개 블록은 다음 방문에도 방문할 수 있게 따로 큐로 저장한 다음에 다시 false로 바꿔준다.
						rainbowQ.offer(new int[] {nextY,nextX});
					}
					visited[nextY][nextX]=true;
					q.offer(new int[] {nextY,nextX});
					
				}
			}
		}
		
		// 무지개 블록은 다음에도 방문할 수 있게 false로 바꿔준다.
		while(!rainbowQ.isEmpty())
		{
			visited[rainbowQ.peek()[0]][rainbowQ.peek()[1]]=false;
			rainbowQ.poll();
		}
		
		// 블록의 수가 더 많으면 갱신
		if(blockCnt<nowBlock)
		{
			blockCnt=nowBlock;
			rainbow=nowRainbow;
			standardY=Y;
			standardX=X;
		}
		else if(blockCnt==nowBlock) // 블록의 수가 같고 무지개 블록의 수가 더 많으면 갱신
		{
			if(rainbow<nowRainbow)
			{
				rainbow=nowRainbow;
				standardY=Y;
				standardX=X;
			}
			else if(rainbow==nowRainbow)
			{
				standardY=Y;
				standardX=X;
			}
		}
	}
}
