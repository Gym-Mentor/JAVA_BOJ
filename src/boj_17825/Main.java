package boj_17825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = 0;
	static int dice[] = new int[10]; // 주사위

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++)
		{
			dice[i]=Integer.parseInt(st.nextToken());
		}
		int[][][] lane = new int[4][50][2]; // 레인의 점수, 레인위에 말이 있는지 체크
		int horse[][] = new int[4][2]; // 말이 위치한 레인, 레인에서의 위치
		
		////////////////////////////////////////////
		// lane위의 점수 초기화
		// 0번 레인
		int num = 2;
		for (int i = 1; i <= 20; i++) {
			lane[0][i][0] = num * i;
		}
		// 1번 레인
		lane[1][0][0] = 10;
		lane[1][1][0] = 13;
		lane[1][2][0] = 16;
		lane[1][3][0] = 19;
		lane[1][4][0] = 25;
		lane[1][5][0] = 30;
		lane[1][6][0] = 35;
		lane[1][7][0] = 40;
		// 2번 레인
		lane[2][1][0] = 20;
		lane[2][2][0] = 22;
		lane[2][3][0] = 24;
		lane[2][4][0] = 25;
		lane[2][5][0] = 30;
		lane[2][6][0] = 35;
		lane[2][7][0] = 40;
		// 3번 레인
		lane[3][0][0] = 30;
		lane[3][1][0] = 28;
		lane[3][2][0] = 27;
		lane[3][3][0] = 26;
		lane[3][4][0] = 25;
		lane[3][5][0] = 30;
		lane[3][6][0] = 35;
		lane[3][7][0] = 40;
		//////////////////////////////////////////
		
		dfs(0, lane, horse, 0,0); // cnt, lane, horse, sum
		
		System.out.println(max);
	}

	static void dfs(int cnt,int[][][] lane, int[][] horse, int sum,int goal)
	{
		if(cnt==10||goal==4)
		{
			if(sum>max)
				max=sum;
			return;
		}
		
		for(int i=0;i<4;i++)
		{
			int Y=horse[i][0];
			int X=horse[i][1];
			int newX=X+dice[cnt]; // 현재 레인에 주사위만큼 더함
			// 레인을 변경해야하는지 체크
			if(Y==0)
			{
				int newLane=changeLane(newX);
				//레인 변경
				if(Y!=newLane)
				{
					newX=0;
					if(newLane==2)newX=1;
					//새로운 레인의 0번째부터 시작
					if(checkLane(lane,newLane,newX)) // 해당레인에 말이 없을 때
					{
						
						//말의 위치 변경
						horse[i][0]=newLane;
						horse[i][1]=newX;
						lane[newLane][newX][1]=1;
						lane[Y][X][1]=0;
						if(lane[newLane][newX][0]==0)
						dfs(cnt+1,lane,horse,sum+lane[newLane][newX][0],goal+1);
						else
						dfs(cnt+1,lane,horse,sum+lane[newLane][newX][0],goal);
						//백 트래킹
						horse[i][0]=Y;
						horse[i][1]=X;
						lane[newLane][newX][1]=0;
						lane[Y][X][1]=1;
					}
				}
				else
				{
					if(checkLane(lane,Y,newX))
					{
						//말의 위치 변경
						horse[i][0]=Y;
						horse[i][1]=newX;
						lane[Y][newX][1]=1;
						lane[Y][X][1]=0;
						if(lane[Y][newX][0]==0)
							dfs(cnt+1,lane,horse,sum+lane[Y][newX][0],goal+1);
						else
							dfs(cnt+1,lane,horse,sum+lane[Y][newX][0],goal);
						//백 트래킹
						horse[i][0]=Y;
						horse[i][1]=X;
						lane[Y][newX][1]=0;
						lane[Y][X][1]=1;
					}
				}
			}
			else
			{
				if(checkLane(lane,Y,newX))
				{
					//말의 위치 변경
					horse[i][0]=Y;
					horse[i][1]=newX;
					lane[Y][newX][1]=1;
					lane[Y][X][1]=0;
					if(lane[Y][newX][0]==0)
						dfs(cnt+1,lane,horse,sum+lane[Y][newX][0],goal+1);
					else
						dfs(cnt+1,lane,horse,sum+lane[Y][newX][0],goal);
					//백 트래킹
					horse[i][0]=Y;
					horse[i][1]=X;
					lane[Y][newX][1]=0;
					lane[Y][X][1]=1;
				}
			}
			
		}
	}
	static boolean checkLane(int[][][] lane, int Y,int X)
	{
		if(Y==0)
		{
			if(lane[Y][X][1]==1)return false;
			if(X==20)
			for(int i=1;i<=3;i++)
			{
				if(lane[i][7][1]==1)return false;
			}
			return true;
		}
		else
		{
			if(X==7)
			{
				if(lane[0][20][1]==1)return false;
				for(int i=1;i<=3;i++)
				{
					if(lane[i][X][1]==1)return false;
				}
			}
			else if(X>=4)
			{
				for(int i=1;i<=3;i++)
				{
					if(lane[i][X][1]==1)return false;
				}
			}
			else
			{
				if(lane[Y][X][1]==1)return false;
			}
			return true;
		}
	}
	static int changeLane(int X) // 레인이 바뀌는 위치인지 확인
	{
		// 1번 레인으로 변경
		if(X==5)
		{
			return 1;
		}
		// 2번 레인으로 변경
		else if(X==10) 
		{
			return 2;
		}
		// 3번 레인으로 변경
		else if(X==15)
		{
			return 3;
		}
		else
		{
			return 0;
		}
	}
}
