package boj_19237;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K,result=-1,size;
	static Board[][] board;
	static Shark[] shark;
	static int[][][] dir;
	static int[] dy= {-1,1,0,0};
	static int[] dx= {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		board=new Board[N][N];
		shark=new Shark[M+1];
		dir=new int[M+1][4][4];
		size=M;
		
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				board[i][j]=new Board(0,0);
				int n=Integer.parseInt(st.nextToken());
				
				if(n!=0)
				{
					board[i][j]=new Board(n,K);
					shark[n]=new Shark(i,j,0,i,j,0);
				}
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++)
		{
			shark[i].dir=Integer.parseInt(st.nextToken())-1;
			shark[i].lastDir=shark[i].dir;
		}
		
		for(int i=1;i<=M;i++)
		{
			for(int j=0;j<4;j++)
			{
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++)
				{
					dir[i][j][k]=Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		solve();
		
		System.out.println(result);
	}
	static void solve()
	{
		//천번 반복
		for(int i=1;i<=1000;i++)
		{
			//피뿌리고 상어이동
			move();
			cleanBlood();
			if(size==1)
			{
				result=i;
				break;
			}
		}
	}
	static void print()	
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(board[i][j].num+""+board[i][j].blood+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void move()
	{
		for(int i=M;i>=1;i--)
		{
			// 피뿌리기
			if(shark[i].X==-1)continue;
			// 방향 찾기
			boolean check=true;
			for(int j=0;j<4;j++)
			{
				// 다음 방향
				int nDir=dir[i][shark[i].dir][j];
				int nextY=shark[i].Y+dy[nDir];
				int nextX=shark[i].X+dx[nDir];
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N) {
					if(board[nextY][nextX].blood==0)
					{
						int tempY=shark[i].Y;
						int tempX=shark[i].X;
						int tempDir=shark[i].dir;
						shark[i]=new Shark(nextY,nextX,nDir,tempY,tempX,tempDir);
						// 격자 안의 나보다 작은 상어 삭제
						if(board[nextY][nextX].num!=0&&board[nextY][nextX].num>i)
						{
							shark[board[nextY][nextX].num].X=-1;
							size--;
						}
						board[nextY][nextX].num=i; // 나보다 작은 상어를 지우기 위해 저장
						check=false;
						break;
					}
				}
			
			}
			if(check) {
				for(int j=0;j<4;j++)
				{
					int nDir=dir[i][shark[i].dir][j];
					int nextY=shark[i].Y+dy[nDir];
					int nextX=shark[i].X+dx[nDir];
					
					if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N) {
						if(board[nextY][nextX].num!=i)continue;
							int tempY=shark[i].Y;
							int tempX=shark[i].X;
							int tempDir=shark[i].dir;
							shark[i]=new Shark(nextY,nextX,nDir,tempY,tempX,tempDir);
							// 격자 안의 나보다 작은 상어 삭제
							board[nextY][nextX].num=i; // 나보다 작은 상어를 지우기 위해 저장
							board[nextY][nextX].blood=-1; // 나보다 작은 상어를 지우기 위해 저장
							break;
					}
				}
			}
		}
	}
	// 피 1깍기
	static void cleanBlood()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(board[i][j].blood>0)
				{
					board[i][j].blood--;
					if(board[i][j].blood==0)
					{
						board[i][j].num=0;
					}
				}
				else
				{
					if(board[i][j].num!=0)
						board[i][j].blood=K;
						
				}
			}
		}
	}
	
	static class Board
	{
		int num;
		int blood;
		public Board(int num, int blood) {
			super();
			this.num = num;
			this.blood = blood;
		}
	}
	static class Shark 
	{
		int Y;
		int X;
		int dir;
		int lastY;
		int lastX;
		int lastDir;
		public Shark(int y, int x, int dir, int lastY,int lastX,int lastDir) {
			super();
			Y = y;
			X = x;
			this.dir = dir;
			this.lastY=lastY;
			this.lastX=lastX;
			this.lastDir=lastDir;
		}
	}
}
