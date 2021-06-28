package boj_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,result=0;
	static int arr[][];
	static int dy[]= {0,1,1};
	static int dx[]= {1,1,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,1,0);
		System.out.println(result);
	}
	
	static void DFS(int Y,int X, int idx)
	{
		if(Y==N-1&&X==N-1) // 목적지에 도착하면 경로하나 추가
		{
			result++;
			return;
		}
		
		if(idx==0||idx==1) // 오른쪽으로 파이프 이동하기
		{
			int nextY=Y+dy[0];
			int nextX=X+dx[0];
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N) // 다음에 이동할 공간이 존재할 때
			{
				if(arr[nextY][nextX]==0) // 벽이 아닐 때 오른쪽으로 이동
				DFS(nextY,nextX,0);
			}
		}
		
		if(idx==0||idx==1||idx==2) // 대각선 아래로 파이프 이동하기
		{
			for(int i=0;i<3;i++) {
				int nextY=Y+dy[i];
				int nextX=X+dx[i];
				if((0<=nextY&&nextY<N&&0<=nextX&&nextX<N)) // 다음에 이동할 공간이 존재할 때
				{
					if(arr[nextY][nextX]==1) // 세 공간중에 한공간이라도 벽이 있으면 break
					break;
				}
				else
				{
					break;
				}

				if(i==2) // 세 공간이 모두 벽이 아닐 때 대각선으로 이동
				{
					DFS(Y+dy[1],X+dx[1],1);
				}
			}
		}
		if(idx==1||idx==2) // 아래쪽으로 파이프 이동하기
		{
			int nextY=Y+dy[2];
			int nextX=X+dx[2];
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N) // 다음에 이동할 공간이 존재할 때
			{
				if(arr[nextY][nextX]==0) // 벽이 아닐 때 오른쪽으로 이동
				DFS(nextY,nextX,2);
			}
		}
	}
}
