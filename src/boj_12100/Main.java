package boj_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N,max=0;
	static int board[][];
	static Stack<pair> q=new Stack<>();
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		board=new int[N][N];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				if(max<board[i][j])
				{
					max=board[i][j];
				}
			}
		}
		
		solve(board, 0);
		System.out.println(max);
	}
	static void solve(int[][] board, int cnt)
	{
		if(cnt==5)
		{
			return;
		}
		move(board,0,cnt+1); // 위로
		move(board,1,cnt+1); // 아래로
		move(board,2,cnt+1); // 오른쪽
		move(board,3,cnt+1); // 왼쪽
	}
	static void print(int[][] board)
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	static void move(int[][] board, int idx, int cnt)
	{
		
		int[][] newBoard=new int[N][N];
		if(idx==0)
		{
			for(int i=0;i<N;i++)
			{
				combine(board,newBoard,0,i,idx);
			}
		}
		else if(idx==1)
		{
			for(int i=0;i<N;i++)
			{
				combine(board,newBoard,N-1,i,idx);
			}
		}
		else if(idx==2) 
		{
			for(int i=0;i<N;i++)
			{
				combine(board,newBoard,i,0,idx);
			}
		}
		else if(idx==3)
		{
			for(int i=0;i<N;i++)
			{
				combine(board,newBoard,i,N-1,idx);
			}
		}
		solve(newBoard,cnt);
	}
	static void combine(int[][] board, int[][] newBoard,int Y,int X, int idx)
	{
		int nextY=Y;
		int nextX=X;
		for(int i=0;i<N;i++)
		{
			if(board[nextY][nextX]!=0) {
				if(q.isEmpty())
				{
					
					q.add(new pair(board[nextY][nextX],false));
				}
				else
				{
					if(q.peek().num==board[nextY][nextX])
					{
						if(!q.peek().check)
							q.add(new pair(q.pop().num*2,true));
						else
							q.add(new pair(board[nextY][nextX],false));
					}
					else
					{
						q.add(new pair(board[nextY][nextX],false));
					}
				}
				if(q.peek().num>max)
				{
					max=q.peek().num;
				}
			}
			nextY+=dy[idx];
			nextX+=dx[idx];
		}
		while(q.size()<N)
		{
			q.add(new pair(0,false));
		}
		nextY-=dy[idx];
		nextX-=dx[idx];
		for(int i=0;i<N;i++)
		{
			newBoard[nextY][nextX]=q.pop().num;
			nextY-=dy[idx];
			nextX-=dx[idx];
		}
	}
	
	static class pair
	{
		int num;
		boolean check;
		public pair(int num, boolean check) {
			super();
			this.num = num;
			this.check = check;
		}
	}
}
