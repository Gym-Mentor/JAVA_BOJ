package boj_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,Y,X,dir,count=0;
	static int dy[]= {-1,0,1,0};
	static int dx[]= {0,1,0,-1};
	static int board[][];
	static boolean isCleaned[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		st= new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		dir=Integer.parseInt(st.nextToken());
		
		board=new int[N][M];
		isCleaned=new boolean[N][M];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				board[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		solve();
		System.out.println(count);
	}

	static void solve()
	{
		int cnt=0;
		clean();
		for(int i=0;i<4;i++)
		{
			if(check()) // 이미 청소했거나 벽인경우
			{
				cnt++;
			}
			else // 청소가 안돼있는 경우
			{
				Y+=dy[dir];
				X+=dx[dir];
				solve();
				return;
			}
		}
		if(cnt==4)
		{
			boolean b=back();
			if(b)return;
			else solve();
		}
	}
	// 후진
	static boolean back()
	{
		int tempDir=(dir+2)%4;
		int nextY=Y+dy[tempDir];
		int nextX=X+dx[tempDir];
		
		//벽이면 작동 정지
		if(board[nextY][nextX]==1)return true;
		else {
			Y=nextY;
			X=nextX;
			return false;
		}
	}
	// 현재 위치 청소
	static void clean()
	{
		if(!isCleaned[Y][X])
		{
			isCleaned[Y][X]=true;
			count++;
		}
	}
	
	// 왼쪽에 청소안했으면 방향 회전 -> 이동
	static boolean check()
	{
		dir=(dir+4-1)%4;
		int nextY=Y+dy[dir];
		int nextX=X+dx[dir];
		
		if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&board[nextY][nextX]==0) // 갈 수 있는 곳일 때
		{
			if(isCleaned[nextY][nextX]) // 이미 청소한 경우
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
}
