package boj_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,min=Integer.MAX_VALUE,size=0;
	static int board[][];
	static CCTV cctv[];
	static int dy[]= {1,0,-1,0};
	static int dx[]= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); // 세로
		M=Integer.parseInt(st.nextToken()); // 가로
		board=new int[N][M];
		cctv=new CCTV[8];
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
				
				//CCTV일 때
				if(1<=board[i][j]&&board[i][j]<=5)
				{
					cctv[size]=new CCTV(i,j,board[i][j]);
					size++; //cctv 개수 저장
				}
			}
		}
		
		solve(board,0);
		
		System.out.println(min);
	}
	static void solve(int[][] board, int idx)
	{
		if(idx==size)
		{
			count(board);
			return;
		}
		watch(board,idx);
	}
	static void watch(int[][] board, int idx) // cctv 방향 감시
	{
		boolean check=false;
		int[][] newBoard=new int[N][M];
		clone(newBoard,board);
		
		//범위체크 시작
		for(int i=0;i<4;i++) {
			
			// newBoard 초기화
			clone(newBoard,board);
			
			// 한 방향만가는 cctv
			if(cctv[idx].kind==1)
			{
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,i);
			}
			else if(cctv[idx].kind==2)
			{
				// 양방향으로 cctv 범위 체크
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,i);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+2)%4);
				if(i==1)
				check=true;
			}else if(cctv[idx].kind==3)
			{
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,i);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+1)%4);
			}
			else if(cctv[idx].kind==4)
			{
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,i);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+1)%4);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+2)%4);
			}
			else if(cctv[idx].kind==5)
			{
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,i);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+1)%4);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+2)%4);
				dfs(newBoard,cctv[idx].Y,cctv[idx].X,(i+3)%4);
				check=true;
			}
			//cctv 범위 체크 끝
			solve(newBoard,idx+1);
			if(check)break;
		}
		
		
	}
	static void dfs(int[][] board,int nowY,int nowX,int dir) // cctv가 감시할수있는 곳 채우기
	{
		board[nowY][nowX]=-1;
		int nextY=nowY+dy[dir];
		int nextX=nowX+dx[dir];
		if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
		{
			if(board[nextY][nextX]!=6)
			dfs(board,nextY,nextX,dir);
		}
			
	}
	static void clone(int[][] newBoard,int[][] board) // 깊은 복사
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				newBoard[i][j]=board[i][j];
			}
		}
	}
	static void count(int[][] board)
	{
		int sum=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(board[i][j]==0)sum++;
			}
		}
		if(sum<min)
		{
			min=sum;
		}
	}
	static class CCTV{
		int Y;
		int X;
		int kind; // cctv 종류
		public CCTV(int y, int x, int kind) {
			super();
			Y = y;
			X = x;
			this.kind = kind;
		}
	}
}
