package boj_14722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 우유 도시
public class Main {
	static int N,max=0,arr[][],DP[][][];
	static int dx[]= {0,1};
	static int dy[]= {1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		N=Integer.parseInt(br.readLine());
		arr=new int[N][N];
		DP=new int[N][N][4];
		for(int i=0;i<N;i++)
		{
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		// 초기화
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				for(int k=0;k<4;k++)
				{
					DP[i][j][k]=-1;
				}
			}
		}
		if(arr[0][0]==0)System.out.println((dfs(0,0,0)+1));
		else System.out.println(dfs(0,0,-1));
		
	}
	static int dfs(int Y,int X,int idx)
	{
		if(Y>N||X>N)return 0;
		
		if(DP[Y][X][idx+1]!=-1)return DP[Y][X][idx+1];
		
		DP[Y][X][idx+1]=0;
		for(int i=0;i<2;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			// DP[nextY][nextX][idx+1]+1과 DP[nextY][nextX][idx] 중에서 더 큰 것 선택
			if(nextY<N&&nextX<N)
			{
				if(arr[nextY][nextX]==(idx+1)%3) DP[Y][X][idx+1]=Math.max(DP[Y][X][idx+1], dfs(nextY,nextX,(idx+1)%3)+1);
				DP[Y][X][idx+1]=Math.max(DP[Y][X][idx+1], dfs(nextY,nextX,idx));
			}
		}
		return DP[Y][X][idx+1];
	}
}
