package boj_3709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,r,t,LY,LX,idx; // 보드의 크기, 우향우 거울의 개수 , 거울좌표,현재 방향
	static int arr[][];
	static int dy[]= {-1,0,1,0}; // 위 오른 아래 왼
	static int dx[]= {0,1,0,-1}; // 위 오른 아래 왼
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			n=Integer.parseInt(st.nextToken());
			r=Integer.parseInt(st.nextToken());
			
			arr=new int[n+2][n+2];
			
			for(int i=0;i<r;i++)
			{
				st= new StringTokenizer(br.readLine()," ");
				int Y=Integer.parseInt(st.nextToken());
				int X=Integer.parseInt(st.nextToken());
				arr[Y][X]=1;
			}
			
			st= new StringTokenizer(br.readLine()," ");
			LY=Integer.parseInt(st.nextToken());
			LX=Integer.parseInt(st.nextToken());
			
			if(LY==0) // 위에서 아래로 쏘는 중
			{
				idx=2;
			}
			else if(LY==n+1) // 아래에서 위로
			{
				idx=0;
			}
			else if(LX==0) // 왼쪽에서 오른쪽
			{
				idx=1;
			}
			else if(LX==n+1) // 오른쪽에서 왼쪽
			{
				idx=3;
			}
			
			dfs(LY,LX);
		}
	}
	static void dfs(int Y,int X)
	{
		if(arr[Y][X]==1)
		{
			idx=(idx+1)%4;
		}
		
		int nextY=Y+dy[idx];
		int nextX=X+dx[idx];
		
		if(0>nextY||nextY>n+1||0>nextX||nextX>n+1) // 범위를 벗어났을 때
		{
			System.out.println(Y+" "+X);
			return;
		}
		
		dfs(nextY,nextX);
	}
}
