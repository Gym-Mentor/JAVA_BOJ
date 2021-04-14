package boj_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,arr[][],tc=1,DP[][];
	static boolean visited[][];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do {
			N=Integer.parseInt(br.readLine());
			if(N==0)break;
			arr=new int[N][N];
			DP=new int[N][N];
			visited=new boolean[N][N];
			for(int i=0;i<N;i++)
			{
				StringTokenizer st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
				{
					arr[i][j]=Integer.parseInt(st.nextToken());
					DP[i][j]=Integer.MAX_VALUE;
				}
			}
			System.out.println("Problem "+tc+": "+solve(0,0));
			tc++;
		}while(true);
	}
	static int solve(int startY,int startX)
	{
		DP[startY][startX]=arr[startY][startX];
		while(true)
		{
			int min=Integer.MAX_VALUE;
			int yIdx=0;
			int xIdx=0;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++) {
					if(!visited[i][j]&&DP[i][j]<min)
					{
						min=DP[i][j];
						yIdx=i;
						xIdx=j;
					}
				}
			}
			if(yIdx==N-1&&xIdx==N-1)return min;
			visited[yIdx][xIdx]=true;
			
			for(int i=0;i<4;i++)
			{
				int nextY=yIdx+dy[i];
				int nextX=xIdx+dx[i];
				
				if(0<=nextY&&nextY<N&&0<=nextX&&nextX<N&&!visited[nextY][nextX])
				{
					if(min+arr[nextY][nextX]<DP[nextY][nextX])
					{
						DP[nextY][nextX]=min+arr[nextY][nextX];
					}
				}
			}
			
		}
	}
}
