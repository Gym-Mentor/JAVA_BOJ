package boj_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 다리 만들기 2 
public class Main {

	static int N,M,input[][],dist[][];
	static boolean visited[][],vertex[];
	static int dy[]= {1,-1,0,0};
	static int dx[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		input=new int[N][M];
		
		visited=new boolean[N][M];
		
		for(int i=0;i<N;i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				input[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int size=0;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(!visited[i][j]&&input[i][j]==1)
				{
					dfs(i,j,++size);
				}
			}
		}
		dist=new int[size][size];
		for(int[] rows : dist)
		{
			Arrays.fill(rows, Integer.MAX_VALUE);
		}
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				if(input[i][j]>=1)
				{
					makeBridge(i,j);
				}
			}
		}
		vertex=new boolean[size];
		int[] minEdge=new int[size];
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		int result=0;
		minEdge[0]=0;
		for(int c=0;c<size;c++)
		{
			int min=Integer.MAX_VALUE;
			int minVertex=0;
			for(int i=0;i<size;i++)
			{
				if(!vertex[i]&&min>minEdge[i])
				{
					min=minEdge[i];
					minVertex=i;
				}
			}
			result+=min;
			vertex[minVertex]=true;
			for(int i=0;i<size;i++)
			{
				if(!vertex[i]&&dist[minVertex][i]!=0&&minEdge[i]>dist[minVertex][i])
				{
					
					minEdge[i]=dist[minVertex][i];
				}
			}
		}
		for(int i=0;i<size;i++)
		{
			if(!vertex[i])
			{
				System.out.println("-1");
				return;
			}
		}
		System.out.println(result);
	}
	static void dfs(int Y,int X, int size)
	{
		visited[Y][X]=true;
		input[Y][X]=size;
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			
			if(0<=nextY&&nextY<N&&0<=nextX&&nextX<M&&!visited[nextY][nextX]&&input[nextY][nextX]==1)
			{
				visited[nextY][nextX]=true;
				input[nextY][nextX]=size;
				dfs(nextY,nextX,size);
			}
		}
	}
	static void makeBridge(int Y,int X)
	{
		for(int i=0;i<4;i++)
		{
			int nextY=Y+dy[i];
			int nextX=X+dx[i];
			while(0<=nextY&&nextY<N&&0<=nextX&&nextX<M)
			{
				if(input[nextY][nextX]!=input[Y][X]&&(Math.abs(nextY-Y)+Math.abs(nextX-X))>=3&&input[nextY][nextX]!=0) // 섬을 만났을 때
				{
					if(dist[input[nextY][nextX]-1][input[Y][X]-1]>(Math.abs(nextY-Y)+Math.abs(nextX-X))-1) // 다리 거리 측정
					{
						dist[input[nextY][nextX]-1][input[Y][X]-1]=(Math.abs(nextY-Y)+Math.abs(nextX-X))-1;
					}
					break;
				}
				else if(input[nextY][nextX]!=input[Y][X]&&(Math.abs(nextY-Y)+Math.abs(nextX-X))<=2&&input[nextY][nextX]!=0) // 섬을 만났는데 거리가1일때
				{
					break;
				}
				else if(input[nextY][nextX]==input[Y][X]) // 같은 섬 일때 break;
				{
					break;
				}
				else
				{
					nextY+=dy[i];
					nextX+=dx[i];
				}
			}
		}
	}
}
