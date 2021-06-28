package boj_19236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max=0;
	static int dy[]= {-1,-1,0,1,1,1,0,-1};
	static int dx[]= {0,-1,-1,-1,0,1,1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int num[][]=new int[16+1][2];
		int loc[][][]=new int[4][4][2];
		for(int i=0;i<4;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++)
			{
				int n=Integer.parseInt(st.nextToken());
				int dir=Integer.parseInt(st.nextToken());
				
				// 숫자의 좌표 저장
				num[n][0]=i;
				num[n][1]=j;
				
				// 좌표의 숫자와 방향 저장
				loc[i][j][0]=n;
				loc[i][j][1]=dir-1;
			}
		}
		
		// 상어한테 잡아먹힌 물고기 좌표 -1,-1로 저장
//		num[loc[0][0][0]][0]=-1;
//		num[loc[0][0][0]][1]=-1;
		int size=loc[0][0][0];
		int dir=loc[0][0][1];
//		loc[0][0][0]=-1;
		loc[0][0][1]=-1;
		solve(num,loc,size,new Shark(0,0,dir));
		System.out.println(max);
	}
	static void solve(int[][] num, int[][][]loc,int sum,Shark shark)
	{
		fishMove(num,loc,shark);
		sharkMove(num,loc,sum,shark);
	}
	static void fishMove(int[][] num, int[][][]loc, Shark shark)
	{
		for(int i=1;i<=16;i++)
		{
			if(loc[num[i][0]][num[i][1]][1]==-1)
			{
				continue; //이미 잡아먹혔으면 패스
			}
			
			//현재 물고기 위치
			int nowY=num[i][0];
			int nowX=num[i][1];
			
			int nowDir=loc[nowY][nowX][1];
			
			for(int j=0;j<8;j++)
			{
				int dir=(nowDir+8+j)%8;
				int nextY=nowY+dy[dir];
				int nextX=nowX+dx[dir];
				if(0<=nextY&&nextY<4&&0<=nextX&&nextX<4&&!(nextY==shark.Y&&nextX==shark.X))
				{
					swap(num,loc,nowY,nowX,nextY,nextX,dir);
					break;
				}
			}
		}
	}
	static void sharkMove(int[][] num, int[][][]loc,int sum,Shark shark)
	{
		int newSum=sum;
		int nextY=shark.Y;
		int nextX=shark.X;
		while(true) {
			nextY+=dy[shark.dir];
			nextX+=dx[shark.dir];
			
			if(0<=nextY&&nextY<4&&0<=nextX&&nextX<4)
			{
				if(loc[nextY][nextX][1]!=-1) {
				int[][] newNum=new int[17][2];
				int[][][] newLoc=new int[4][4][2];
				clone(num,newNum,loc,newLoc);
				Shark newShark=new Shark(shark.Y,shark.X,shark.dir);
				newSum=sharkEat(newNum,newLoc,nextY,nextX,sum,newShark);
				if(sum+newSum>max)
				{
					max=sum+newSum;
				}
				solve(newNum,newLoc,sum+newSum,newShark);
				}
			}
			else
			{
				break;
			}
		}
	}
	static void clone(int[][] num, int[][] newNum, int[][][] loc,int[][][] newLoc)
	{
		for(int i=0;i<17;i++)
		{
			for(int j=0;j<2;j++)
			{
				newNum[i][j]=num[i][j];
			}
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				for(int k=0;k<2;k++)
				newLoc[i][j][k]=loc[i][j][k];
			}
		}
	}
	static int sharkEat(int[][] num, int[][][]loc,int nextY,int nextX,int sum,Shark shark) 
	{
		shark.Y=nextY;
		shark.X=nextX;
		shark.dir=loc[nextY][nextX][1];
		loc[nextY][nextX][1]=-1;
		return loc[nextY][nextX][0];
	}
	static void print(int[][] num, int[][][]loc,int sum,Shark shark)
	{
		System.out.println(sum+" "+shark.Y+" "+shark.X+" "+shark.dir+" ");
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(loc[i][j][0]+" "+loc[i][j][1]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static class Shark{
		int Y;
		int X;
		int dir;
		public Shark(int y, int x, int dir) {
			super();
			Y = y;
			X = x;
			this.dir = dir;
		}
	}
	static void swap(int[][] num,int[][][] loc,int nowY,int nowX,int nextY,int nextX,int nowDir)
	{
		int nextNum=loc[nextY][nextX][0];
		int nextDir=loc[nextY][nextX][1];
		int nowNum=loc[nowY][nowX][0];
		
		// 각 물고기의 좌표 바꾸기
		num[nowNum][0]=nextY;
		num[nowNum][1]=nextX;
		num[nextNum][0]=nowY;
		num[nextNum][1]=nowX;
		
		// 각 좌표의 물고기와 방향 바꾸기
		loc[nowY][nowX][0]=nextNum;
		loc[nowY][nowX][1]=nextDir;
		loc[nextY][nextX][0]=nowNum;
		loc[nextY][nextX][1]=nowDir;
	}
}
